package spring.kafka.demo.simplest.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import spring.kafka.demo.common.config.C1Topics;

@Component
public class D1KafkaListener {

	@Autowired
	private D1StringPublisher publisher;

	@KafkaListener(topics = C1Topics.TOPIC_1, containerFactory = "d1KafkaListenerContainerFactory")
	public void receiveMessage(String message) {
		publisher.send(message);
	}

}
