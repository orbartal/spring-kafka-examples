package spring.kafka.demo.consumers.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import spring.kafka.demo.common.config.C1Topics;
import spring.kafka.demo.consumers.groups.publishers.D5StringPublisher1;
import spring.kafka.demo.consumers.groups.publishers.D5StringPublisher2;
import spring.kafka.demo.consumers.groups.publishers.D5StringPublisher3;

@Configuration
public class D5KafkaListner {
	
	@Autowired
	private D5StringPublisher1 messagePublisher1;
	
	@Autowired
	private D5StringPublisher2 messagePublisher2;
	
	@Autowired
	private D5StringPublisher3 messagePublisher3;

	@KafkaListener(topics = C1Topics.TOPIC_5, groupId = "A5", clientIdPrefix = "string", containerFactory = "d5KafkaListenerContainerFactory")
	public void receiveMessage01(String message) {
		messagePublisher1.send(message);
	}

	@KafkaListener(topics = C1Topics.TOPIC_5, groupId = "A5", clientIdPrefix = "string", containerFactory = "d5KafkaListenerContainerFactory")
	public void receiveMessage02(String message) {
		messagePublisher2.send(message);
	}

	@KafkaListener(topics = C1Topics.TOPIC_5, groupId = "B5", clientIdPrefix = "string", containerFactory = "d5KafkaListenerContainerFactory")
	public void receiveMessage03(String message) {
		messagePublisher3.send(message);
	}

}