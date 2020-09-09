package spring.kafka.demo.common.consumer.listener;

import java.util.Map;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;

public class KafkaListenerContainerFactoryString extends ConcurrentKafkaListenerContainerFactory<Integer, String> {

	public KafkaListenerContainerFactoryString(C1KafkaPropertiesFactory propertiesFactory) {
		Map<String, Object> configs = propertiesFactory.getConsumerProperties();
		this.setConsumerFactory(new DefaultKafkaConsumerFactory<>(configs));
	}

}