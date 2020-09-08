package spring.kafka.demo.simplest.consumer;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

import spring.kafka.demo.simplest.config.D1KafkaPropertiesFactory;

@Component
public class D1KafkaListenerContainerFactory extends ConcurrentKafkaListenerContainerFactory <Integer, String> {

	@Autowired
	private D1KafkaPropertiesFactory propertiesFactory;

	@PostConstruct
	private void postConstruct() {
		Map<String, Object> consumerConfigs = propertiesFactory.getConsumerProperties();
		ConsumerFactory<Integer, String> consumerFactory = new DefaultKafkaConsumerFactory<>(consumerConfigs);
		this.setConsumerFactory(consumerFactory);
	}

}
