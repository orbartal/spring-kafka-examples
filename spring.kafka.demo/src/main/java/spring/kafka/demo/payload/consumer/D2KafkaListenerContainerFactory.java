package spring.kafka.demo.payload.consumer;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;
import spring.kafka.demo.common.consumer.listener.KafkaListenerContainerFactoryDto;

@Component
public class D2KafkaListenerContainerFactory extends KafkaListenerContainerFactoryDto {

	public D2KafkaListenerContainerFactory(C1KafkaPropertiesFactory propertiesFactory) {
		super(propertiesFactory);
	}

}
