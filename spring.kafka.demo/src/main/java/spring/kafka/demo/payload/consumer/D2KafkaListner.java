package spring.kafka.demo.payload.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import spring.kafka.demo.common.config.C1Topics;
import spring.kafka.demo.common.model.MessageDto;

@Configuration
public class D2KafkaListner {

	@Autowired
	private D2MessageDtoPublisher publisher;

	@KafkaListener(topics = C1Topics.TOPIC_2, groupId = "A2", containerFactory = "d2KafkaListenerContainerFactory")
	public void receiveRecord(@Payload ConsumerRecord<Integer, MessageDto> record) {
		MessageDto payload = record.value();
		publisher.send(payload);
	}
}
