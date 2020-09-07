package spring.kafka.demo.simplest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.kafka.demo.simplest.consumer.MyMessagePublisher;
import spring.kafka.demo.simplest.producer.MyKafkaSender;
import spring.kafka.demo.simplest.config.Topics;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainKafkaSpringSimplestTests {

	@Autowired
	private MyMessagePublisher myMessagePublisher;

    @Autowired
    private MyKafkaSender sender;

    @Test
    public void test1() throws Exception {
    	MySubscriber<String> subscriber = new MySubscriber<>();
    	myMessagePublisher.addSubscriber(subscriber);

	    List<String> items = List.of("a1", "b2", "c3");
	    items.forEach(i->sender.sendMessage(Topics.TOPIC_1, i));

	    Thread.sleep(2000);
	    Assert.assertTrue(subscriber.consumedElements.containsAll(items));
	    Assert.assertTrue(items.containsAll(subscriber.consumedElements));
    }
}
