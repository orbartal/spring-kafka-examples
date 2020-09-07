package spring.kafka.demo.simplest.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class ReceiverConfig {

	@Value("${kafka.bootstrap.servers}")
	private String bootstrapServers;
	
	@Value("${kafka.group.id}")
	private String kafkaGroupId;

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		Map<String, Object> consumerConfigs = consumerConfigs();
		ConsumerFactory<Integer, String> consumerFactory = new DefaultKafkaConsumerFactory<>(consumerConfigs);
		factory.setConsumerFactory(consumerFactory);
		return factory;
	}

	private Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		//host:port used for establishing the connections to the Kakfa cluster
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		// consumer groups allow a pool of processes to divide the work of consuming and processing records
		props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaGroupId);
		return props;
	}

}
