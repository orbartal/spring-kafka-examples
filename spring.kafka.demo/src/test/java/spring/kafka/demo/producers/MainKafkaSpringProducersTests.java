package spring.kafka.demo.producers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring.kafka.demo.simplest.D1Subscriber;
import spring.kafka.demo.simplest.config.D1KafkaPropertiesFactory;
import spring.kafka.demo.simplest.config.D1Topics;
import spring.kafka.demo.simplest.consumer.D1StringPublisher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainKafkaSpringProducersTests {

	@Autowired
	private D1StringPublisher internalPublisher;

    @Autowired
    private D1KafkaPropertiesFactory propertiesFactory;

    @Test
    public void testMultiProducers() throws Exception {

    	int size = 5;
    	List<D2KafkaProducer> producers = IntStream.range(0, size).boxed().map(i->getProducer(i)).collect(Collectors.toList());

    	//Given
    	D1Subscriber<String> subscriber = new D1Subscriber<>();
    	internalPublisher.addSubscriber(subscriber);

    	//When
	    List<String> messages = IntStream.range(0, size).boxed().map(i->UUID.randomUUID().toString()).sorted().collect(Collectors.toList());
	    System.out.println(messages);

	    IntStream.range(0, size).forEach(i->producers.get(i).sendMessage(D1Topics.TOPIC_1, messages.get(i)));
	    Thread.sleep(5000);

	    //Then
	    List<String> actual = subscriber.getConsumedElements().stream().sorted().collect(Collectors.toList());
	    Assert.assertTrue(actual.containsAll(messages));
	    Assert.assertTrue(messages.containsAll(actual));
    }

	private D2KafkaProducer getProducer(int i) {
		return new D2KafkaProducer(propertiesFactory.getProducerProperties());
	}
}
