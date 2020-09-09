package spring.kafka.demo.consumers.formats.factory;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;
import spring.kafka.demo.common.consumer.listener.KafkaListenerContainerFactoryDto;

@Component
public class D4KafkaListenerContainerFactory3 extends KafkaListenerContainerFactoryDto {

	public D4KafkaListenerContainerFactory3(C1KafkaPropertiesFactory propertiesFactory) {
		super(propertiesFactory);
	}

}
