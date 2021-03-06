package spring.kafka.demo.simplest.consumer;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;
import spring.kafka.demo.common.consumer.listener.KafkaListenerContainerFactoryString;

@Component
public class D1KafkaListenerContainerFactory extends KafkaListenerContainerFactoryString {

	public D1KafkaListenerContainerFactory(C1KafkaPropertiesFactory propertiesFactory) {
		super(propertiesFactory);
	}
}
