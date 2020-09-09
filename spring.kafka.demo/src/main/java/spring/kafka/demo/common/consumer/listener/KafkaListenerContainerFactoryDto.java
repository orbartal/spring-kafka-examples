package spring.kafka.demo.common.consumer.listener;

import java.util.Map;

import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;

public class KafkaListenerContainerFactoryDto extends ConcurrentKafkaListenerContainerFactory<Integer, String> {

	public KafkaListenerContainerFactoryDto(C1KafkaPropertiesFactory propertiesFactory) {
		Map<String, Object> configs = propertiesFactory.getConsumerProperties2();
		this.setConsumerFactory(new DefaultKafkaConsumerFactory<>(configs, new IntegerDeserializer(),  getJsonDeserializer()));
	}

	private JsonDeserializer<Object> getJsonDeserializer() {
		final JsonDeserializer<Object> jsonDeserializer = new JsonDeserializer<>();
        jsonDeserializer.addTrustedPackages("*");
		return jsonDeserializer;
	}


}