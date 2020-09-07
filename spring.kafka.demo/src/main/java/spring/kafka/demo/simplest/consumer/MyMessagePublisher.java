package spring.kafka.demo.simplest.consumer;

import java.util.concurrent.Flow.Subscriber;

import org.springframework.stereotype.Component;

import java.util.concurrent.SubmissionPublisher;

@Component
public class MyMessagePublisher {

   private final SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

	void send(String message){
		publisher.submit(message);
	}

	public void addSubscriber(Subscriber<String> subscriber){
	    publisher.subscribe(subscriber);
	}

}
