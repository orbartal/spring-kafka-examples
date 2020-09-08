package spring.kafka.demo.payload.consumer;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

import spring.kafka.demo.simplest.config.D1KafkaPropertiesFactory;

@Component
public class D2KafkaListenerContainerFactory extends ConcurrentKafkaListenerContainerFactory <Integer, String> {

	@Autowired
	private D1KafkaPropertiesFactory propertiesFactory;

	@PostConstruct
	private void postConstruct() {
		Map<String, Object> configs = propertiesFactory.getConsumerProperties2();
		this.setConsumerFactory(new DefaultKafkaConsumerFactory<>(configs, new IntegerDeserializer(),  getJsonDeserializer()));
	}

	private JsonDeserializer<Object> getJsonDeserializer() {
		final JsonDeserializer<Object> jsonDeserializer = new JsonDeserializer<>();
        jsonDeserializer.addTrustedPackages("*");
		return jsonDeserializer;
	}

}
