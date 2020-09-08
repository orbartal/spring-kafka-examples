package spring.kafka.demo.simplest.producer;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import spring.kafka.demo.simplest.config.D1KafkaPropertiesFactory;

@Component
public class D1KafkaProducer {

	@Autowired
	private D1KafkaPropertiesFactory propertiesFactory;

	private KafkaTemplate<Integer, String> kafkaTemplate;

	@PostConstruct
	private void postConstruct() {
		Map<String, Object> producerConfigs = propertiesFactory.getProducerProperties();
		ProducerFactory<Integer, String> producerFactory = new DefaultKafkaProducerFactory<>(producerConfigs);
		kafkaTemplate = new KafkaTemplate<Integer, String>(producerFactory);
	}

	public void send(String topic, String message) {
		ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, message);
		future.addCallback(new D1ProducerCallBack<>(topic, message));
	}

}
