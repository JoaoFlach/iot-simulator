package com.joaoflach.main.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.joaoflach.main.config.PropertyType.*;
import static com.joaoflach.main.config.OperatorSign.*;
import com.joaoflach.main.dao.ProducerChannelDao;
import com.joaoflach.main.dao.ProducerChannelPropertyDao;
import com.joaoflach.main.dao.ProducerDao;
import com.joaoflach.main.entity.ProducerChannel;
import com.joaoflach.main.entity.ProducerChannelProperty;
import com.joaoflach.main.entity.ProducerConnection;

@Component
public class HumhubProcessor {
	private static final Logger log = LoggerFactory.getLogger(HumhubProcessor.class);

	@Autowired
	private ProducerChannelDao producerChannelDao;

	@Autowired
	private ProducerChannelPropertyDao producerChannelPropertyDao;

	@Autowired
	private ProducerDao producerDao;

	// @Async("asyncTaskExecutor")
	public void process(ProducerConnection i) {
		log.debug("started process {}", i);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			log.error("deu erro");
		}
		log.debug("ended process");
	}

	// @Async("asyncTaskExecutor")
	public void executeProducerConnection(ProducerConnection producerConnection) {
		log.debug("Processing connection {}", producerConnection);

		// get origin channel
		ProducerChannel producerChannel = producerChannelDao.findById(producerConnection.getOriginChannelId()).get();

		// call origin channel
		String producerResponse = 
				httpConnection(producerChannel.getHttpMethod(), producerChannel.getInternetAddress());
		if(producerResponse != null) {
			JsonNode jsonNode = transformStringToJsonNode(producerResponse);
			if (jsonNode != null) {
				// call actuator
				ProducerChannelProperty producerChannelProperty = 
						producerChannelPropertyDao.findById(producerConnection.getWhenProperty()).get();
				if(producerChannelProperty!=null) {
					log.debug("able to get producer channel property [{}, {}]", 
							producerChannelProperty.getType(), producerChannelProperty.getPropertyName());
					
					jsonNode = jsonNode.get(producerChannelProperty.getPropertyName());
					
					if(NUMBER.equals(producerChannelProperty.getType())) {
						Long propertyValue = jsonNode.asLong();
						log.info("property {} value {}", 
								producerChannelProperty.getPropertyName(), propertyValue);
					}
					
					if(TEXT.equals(producerChannelProperty.getType())) {
						String propertyValue = jsonNode.asText();
						log.info("property {} value {}", 
								producerChannelProperty.getPropertyName(), propertyValue);
					}
					
					if(BOOLEAN.equals(producerChannelProperty.getType())) {
						Boolean propertyValue = jsonNode.asBoolean();
						log.info("property {} value {}", 
								producerChannelProperty.getPropertyName(), propertyValue);
					}
					
					
				} else {
					log.info("not able to get producer channel property");
				}
					
			} else {
				log.info("Json string could not be converted to JsonNode");
			}
		} else {
			log.info("No response received from producer {}", producerChannel.getInternetAddress());
		}

		
	}

	private void evaluateOriginState(String producerResponse) {
		JsonNode jsonNode = transformStringToJsonNode(producerResponse);
		if (jsonNode != null) {
			// call actuator
			
		} else {
			log.info("Json string could not be converted to JsonNode");
		}

	}

	private String httpConnection(String method, String URLText) {
		String result = null;

		try {
			URL URL = new URL(URLText);
			HttpURLConnection conn = (HttpURLConnection) URL.openConnection();
			conn.setRequestMethod(method);
			int status = conn.getResponseCode();
			if (status == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				result = content.toString();
			}
		} catch (MalformedURLException e) {
			log.error("Malformed URL {}", URLText);
		} catch (IOException e) {
			log.error("IO Exception {}", e);
		}

		return result;
	}

	private JsonNode transformStringToJsonNode(String json) {
		ObjectMapper om = new ObjectMapper();
		JsonNode result = null;
		try {
			return om.readTree(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Convert to JsonNode error {}", e);
		}

		return result;
	}

}
