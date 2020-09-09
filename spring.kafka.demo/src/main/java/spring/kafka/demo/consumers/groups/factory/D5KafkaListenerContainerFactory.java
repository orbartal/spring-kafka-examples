package spring.kafka.demo.consumers.groups.factory;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;
import spring.kafka.demo.common.consumer.listener.KafkaListenerContainerFactoryString;

@Component
public class D5KafkaListenerContainerFactory extends KafkaListenerContainerFactoryString {

	public D5KafkaListenerContainerFactory(C1KafkaPropertiesFactory propertiesFactory) {
		super(propertiesFactory);
	}

}
