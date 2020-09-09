package spring.kafka.demo.common.consumer.publisher;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

public class D1MessagePublisher<T> {

	private final SubmissionPublisher<T> publisher = new SubmissionPublisher<>();

	public void send(T message) {
		publisher.submit(message);
	}

	public void addSubscriber(Subscriber<T> subscriber) {
		publisher.subscribe(subscriber);
	}

}
