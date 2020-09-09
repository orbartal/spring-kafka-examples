package spring.kafka.demo.consumers.formats.factory;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;
import spring.kafka.demo.common.consumer.listener.KafkaListenerContainerFactoryString;

@Component
public class D4KafkaListenerContainerFactory2 extends KafkaListenerContainerFactoryString {

	public D4KafkaListenerContainerFactory2(C1KafkaPropertiesFactory propertiesFactory) {
		super(propertiesFactory);
	}

}
