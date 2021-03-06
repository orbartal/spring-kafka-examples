package spring.kafka.demo.simplest;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class D1Subscriber<T> implements Subscriber<T> {

    private Subscription subscription;
    private List<T> consumedElements = new LinkedList<>();
 
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

	@Override
	public void onNext(T item) {
		System.out.println("Got : " + item);
		consumedElements.add(item);
		subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		System.err.println(t);
	}

	@Override
	public void onComplete() {
		System.out.println("Done");
	}
	
	public List<T> getConsumedElements() {
		return Collections.unmodifiableList(consumedElements);
	}
}