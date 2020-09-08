package spring.kafka.demo.payload.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import spring.kafka.demo.payload.model.MessageDto;
import spring.kafka.demo.simplest.config.D1Topics;
import spring.kafka.demo.simplest.consumer.D1MessagePublisher;

@Configuration
public class KafkaListner {

	@Autowired
	private D1MessagePublisher<MessageDto> myMessagePublisher;

	@KafkaListener(topics = D1Topics.TOPIC_3, containerFactory = "d2KafkaListenerContainerFactory")
	public void receiveRecord(@Payload ConsumerRecord<Integer, MessageDto> record) {
		MessageDto payload = record.value();
		myMessagePublisher.send(payload);
	}
}
