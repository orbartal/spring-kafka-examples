package spring.kafka.demo.payload.producer;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import spring.kafka.demo.payload.model.MessageDto;
import spring.kafka.demo.simplest.config.D1KafkaPropertiesFactory;
import spring.kafka.demo.simplest.producer.D1ProducerCallBack;

@Component
public class D3KafkaProducer {

	@Autowired
	private D1KafkaPropertiesFactory propertiesFactory;

	private KafkaTemplate<Integer, MessageDto> kafkaTemplate;

	@PostConstruct
	private void postConstruct() {
		Map<String, Object> producerConfigs = propertiesFactory.getProducerProperties2();
		ProducerFactory<Integer, MessageDto> producerFactory = new DefaultKafkaProducerFactory<>(producerConfigs);
		kafkaTemplate = new KafkaTemplate<Integer, MessageDto>(producerFactory);
	}

	public void send(String topic, MessageDto message) {
		ListenableFuture<SendResult<Integer, MessageDto>> future = kafkaTemplate.send(topic, message);
		future.addCallback(new D1ProducerCallBack<>(topic, message.toString()));
	}

}
