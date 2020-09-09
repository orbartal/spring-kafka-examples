package spring.kafka.demo.simplest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring.kafka.demo.simplest.config.D1Topics;
import spring.kafka.demo.simplest.consumer.D1StringPublisher;
import spring.kafka.demo.simplest.producer.D1KafkaProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainKafkaSpringSimplestTests {

	@Autowired
	private D1StringPublisher internalPublisher;

    @Autowired
    private D1KafkaProducer kafkaProducer;

    @Test
    public void test1() throws Exception {

    	//Given
    	D1Subscriber<String> subscriber = new D1Subscriber<>();
    	internalPublisher.addSubscriber(subscriber);

    	//When
	    List<String> items = List.of("a1", "b2", "c3");
	    items.forEach(i->kafkaProducer.send(D1Topics.TOPIC_1, i));
	    Thread.sleep(5000);

	    //Then
	    List<String> actual = subscriber.getConsumedElements();
	    Assert.assertTrue(actual.containsAll(items));
	    Assert.assertTrue(items.containsAll(actual));
    }
}
