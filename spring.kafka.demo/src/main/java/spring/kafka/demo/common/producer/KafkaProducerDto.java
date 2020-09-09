package spring.kafka.demo.common.producer;

import java.util.Map;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;
import spring.kafka.demo.common.model.MessageDto;

public class KafkaProducerDto {

	private KafkaTemplate<Integer, MessageDto> kafkaTemplate;

	public KafkaProducerDto(C1KafkaPropertiesFactory propertiesFactory) {
		Map<String, Object> producerConfigs = propertiesFactory.getProducerProperties2();
		ProducerFactory<Integer, MessageDto> producerFactory = new DefaultKafkaProducerFactory<>(producerConfigs);
		kafkaTemplate = new KafkaTemplate<Integer, MessageDto>(producerFactory);
	}

	public void send(String topic, MessageDto message) {
		ListenableFuture<SendResult<Integer, MessageDto>> future = kafkaTemplate.send(topic, message);
		future.addCallback(new FutureProducerCallBack<>(topic, message.toString()));
	}

}
