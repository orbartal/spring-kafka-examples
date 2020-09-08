package spring.kafka.demo.simplest.consumer;

import java.util.concurrent.Flow.Subscriber;

import org.springframework.stereotype.Component;

import java.util.concurrent.SubmissionPublisher;

@Component
public class D1MessagePublisher<T> {

   private final SubmissionPublisher<T> publisher = new SubmissionPublisher<>();

	void send(T message){
		publisher.submit(message);
	}

	public void addSubscriber(Subscriber<T> subscriber){
	    publisher.subscribe(subscriber);
	}

}
