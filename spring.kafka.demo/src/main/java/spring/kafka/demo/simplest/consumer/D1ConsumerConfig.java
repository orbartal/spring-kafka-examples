package spring.kafka.demo.simplest.consumer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import spring.kafka.demo.simplest.config.D1KafkaPropertiesFactory;

@Configuration
@EnableKafka
public class D1ConsumerConfig {

	@Autowired
	private D1KafkaPropertiesFactory propertiesFactory;

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		Map<String, Object> consumerConfigs = propertiesFactory.getConsumerProperties();
		ConsumerFactory<Integer, String> consumerFactory = new DefaultKafkaConsumerFactory<>(consumerConfigs);
		factory.setConsumerFactory(consumerFactory);
		return factory;
	}

}
