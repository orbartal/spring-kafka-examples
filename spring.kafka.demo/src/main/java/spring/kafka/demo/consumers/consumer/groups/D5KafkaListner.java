package spring.kafka.demo.consumers.consumer.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import spring.kafka.demo.simplest.config.D1Topics;

@Configuration
public class D5KafkaListner {
	
	@Autowired
	private D5StringPublisher1 messagePublisher1;
	
	@Autowired
	private D5StringPublisher2 messagePublisher2;
	
	@Autowired
	private D5StringPublisher3 messagePublisher3;

	@KafkaListener(topics = D1Topics.TOPIC_5, groupId = "A", clientIdPrefix = "string", containerFactory = "d1KafkaListenerContainerFactory")
	public void receiveMessage01(String message) {
		messagePublisher1.send(message);
	}

	@KafkaListener(topics = D1Topics.TOPIC_5, groupId = "A", clientIdPrefix = "string", containerFactory = "d1KafkaListenerContainerFactory")
	public void receiveMessage02(String message) {
		messagePublisher2.send(message);
	}

	@KafkaListener(topics = D1Topics.TOPIC_5, groupId = "B", clientIdPrefix = "string", containerFactory = "d1KafkaListenerContainerFactory")
	public void receiveMessage03(String message) {
		messagePublisher3.send(message);
	}

}