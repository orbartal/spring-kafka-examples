package spring.kafka.demo.simplest.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import spring.kafka.demo.simplest.config.D1Topics;


@Component
public class D1KafkaConsumer {

	@Autowired
	private D1MessagePublisher myMessagePublisher;

	@KafkaListener(topics = D1Topics.TOPIC_1)
	public void receiveMessage(String message) {
		myMessagePublisher.send(message);
	}

}
