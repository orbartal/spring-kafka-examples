package spring.kafka.demo.common.producer;

import java.util.Map;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;

public class KafkaProducerString {

	private KafkaTemplate<Integer, String> kafkaTemplate;

	public KafkaProducerString(C1KafkaPropertiesFactory propertiesFactory) {
		Map<String, Object> producerConfigs = propertiesFactory.getProducerProperties();
		ProducerFactory<Integer, String> producerFactory = new DefaultKafkaProducerFactory<>(producerConfigs);
		kafkaTemplate = new KafkaTemplate<Integer, String>(producerFactory);
	}

	public void send(String topic, String message) {
		ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, message);
		future.addCallback(new FutureProducerCallBack<>(topic, message));
	}

}
