package spring.kafka.demo.simplest.producer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import spring.kafka.demo.simplest.config.D1KafkaPropertiesFactory;

@Configuration
public class D1ProducerConfig {

	@Autowired
	private D1KafkaPropertiesFactory propertiesFactory;

    @Bean
    public KafkaTemplate<Integer, String> kafkaTemplate() {
        Map<String, Object> producerConfigs = propertiesFactory.getProducerProperties();
		ProducerFactory<Integer, String> producerFactory = new DefaultKafkaProducerFactory<>(producerConfigs);
		return new KafkaTemplate<Integer, String>(producerFactory);
    }

}
