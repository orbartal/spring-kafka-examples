package spring.kafka.demo.simplest.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class D1KafkaProducer {

	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;

	public void sendMessage(String topic, String message) {
		ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, message);
		future.addCallback(new D1ProducerCallBack(topic, message));
	}
}
