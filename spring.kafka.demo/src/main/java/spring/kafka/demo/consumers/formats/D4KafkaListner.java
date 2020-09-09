package spring.kafka.demo.consumers.formats;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import spring.kafka.demo.common.config.C1Topics;
import spring.kafka.demo.common.model.MessageDto;
import spring.kafka.demo.consumers.formats.publishers.D4BytesPublisher;
import spring.kafka.demo.consumers.formats.publishers.D4MessageDtoPublisher;
import spring.kafka.demo.consumers.formats.publishers.D4StringPublisher;

@Configuration
public class D4KafkaListner {

	@Autowired
	private D4BytesPublisher bytesMessagePublisher;

	@Autowired
	private D4StringPublisher stringMessagePublisher;

	@Autowired
	private D4MessageDtoPublisher dtoMessagePublisher;

	@KafkaListener(topics = C1Topics.TOPIC_4, groupId = "A4", clientIdPrefix = "bytearray", containerFactory = "d4KafkaListenerContainerFactory1")
	public void receiveBytes(@Payload ConsumerRecord<Integer, Object> record) {
		byte[] payload = (byte[]) record.value();
		bytesMessagePublisher.send(payload);
	}

	@KafkaListener(topics = C1Topics.TOPIC_4, groupId = "B4", clientIdPrefix = "string", containerFactory = "d4KafkaListenerContainerFactory2")
	public void receiveMessage(String message) {
		stringMessagePublisher.send(message);
	}

	@KafkaListener(topics = C1Topics.TOPIC_4, groupId = "C4", clientIdPrefix = "json", containerFactory = "d4KafkaListenerContainerFactory3")
	public void receiveDto(@Payload ConsumerRecord<Integer, MessageDto> record) {
		MessageDto payload = record.value();
		dtoMessagePublisher.send(payload);
	}

}