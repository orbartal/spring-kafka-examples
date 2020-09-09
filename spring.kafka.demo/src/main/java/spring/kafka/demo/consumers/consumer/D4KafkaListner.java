package spring.kafka.demo.consumers.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import spring.kafka.demo.consumers.publishers.D4BytesPublisher;
import spring.kafka.demo.consumers.publishers.D4MessageDtoPublisher;
import spring.kafka.demo.consumers.publishers.D4StringPublisher;
import spring.kafka.demo.payload.model.MessageDto;
import spring.kafka.demo.simplest.config.D1Topics;

@Configuration
public class D4KafkaListner {

	@Autowired
	private D4BytesPublisher bytesMessagePublisher;

	@Autowired
	private D4StringPublisher stringMessagePublisher;
	
	@Autowired
	private D4MessageDtoPublisher dtoMessagePublisher;

	@KafkaListener(topics = D1Topics.TOPIC_4, groupId = "A", clientIdPrefix = "json", containerFactory = "d4KafkaListenerContainerFactory")
	public void receiveBytes(@Payload ConsumerRecord<Integer, Object> record) {
		byte[] payload = (byte[])record.value();
		bytesMessagePublisher.send(payload);
	}

	@KafkaListener(topics = D1Topics.TOPIC_4, groupId = "B", clientIdPrefix = "string", containerFactory = "d1KafkaListenerContainerFactory")
	public void receiveMessage(String message) {
		stringMessagePublisher.send(message);
	}

	@KafkaListener(topics = D1Topics.TOPIC_4, groupId = "C", clientIdPrefix = "bytearray", containerFactory = "d2KafkaListenerContainerFactory")
	public void receiveRecord(@Payload ConsumerRecord<Integer, MessageDto> record) {
		MessageDto payload = record.value();
		dtoMessagePublisher.send(payload);
	}

}