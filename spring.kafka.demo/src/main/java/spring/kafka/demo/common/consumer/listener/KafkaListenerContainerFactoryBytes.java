package spring.kafka.demo.common.consumer.listener;

import java.util.Map;

import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;

public class KafkaListenerContainerFactoryBytes extends ConcurrentKafkaListenerContainerFactory <Integer, byte[]> {

	public KafkaListenerContainerFactoryBytes(C1KafkaPropertiesFactory propertiesFactory) {
		Map<String, Object> configs = propertiesFactory.getConsumerProperties2();
		this.setConsumerFactory(new DefaultKafkaConsumerFactory<>(configs, new IntegerDeserializer(),  new ByteArrayDeserializer()));
	}

}
