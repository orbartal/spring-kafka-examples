package spring.kafka.demo.simplest.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import spring.kafka.demo.simplest.config.Topics;


@Component
public class MyKafkaListener {

	@Autowired
	private MyMessagePublisher myMessagePublisher;

	@KafkaListener(topics = Topics.TOPIC_1)
	public void receiveMessage(String message) {
		myMessagePublisher.send(message);
	}

}
