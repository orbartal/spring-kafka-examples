package spring.kafka.demo.consumers.formats.factory;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;
import spring.kafka.demo.common.consumer.listener.KafkaListenerContainerFactoryBytes;

@Component
public class D4KafkaListenerContainerFactory1 extends KafkaListenerContainerFactoryBytes {

	public D4KafkaListenerContainerFactory1(C1KafkaPropertiesFactory propertiesFactory) {
		super(propertiesFactory);
	}

}
