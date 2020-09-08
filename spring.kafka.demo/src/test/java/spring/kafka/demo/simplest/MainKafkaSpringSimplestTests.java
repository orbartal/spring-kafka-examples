package spring.kafka.demo.simplest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.kafka.demo.simplest.consumer.D1MessagePublisher;
import spring.kafka.demo.simplest.producer.D1KafkaProducer;
import spring.kafka.demo.simplest.config.D1Topics;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainKafkaSpringSimplestTests {

	@Autowired
	private D1MessagePublisher myMessagePublisher;

    @Autowired
    private D1KafkaProducer sender;

    @Test
    public void test1() throws Exception {
    	D1Subscriber<String> subscriber = new D1Subscriber<>();
    	myMessagePublisher.addSubscriber(subscriber);

	    List<String> items = List.of("a1", "b2", "c3");
	    items.forEach(i->sender.sendMessage(D1Topics.TOPIC_1, i));

	    Thread.sleep(2000);
	    Assert.assertTrue(subscriber.consumedElements.containsAll(items));
	    Assert.assertTrue(items.containsAll(subscriber.consumedElements));
    }
}
