package spring.kafka.demo.consumers.groups;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring.kafka.demo.consumers.consumer.groups.D5StringPublisher1;
import spring.kafka.demo.consumers.consumer.groups.D5StringPublisher2;
import spring.kafka.demo.consumers.consumer.groups.D5StringPublisher3;
import spring.kafka.demo.simplest.D1Subscriber;
import spring.kafka.demo.simplest.config.D1Topics;
import spring.kafka.demo.simplest.producer.D1KafkaProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainKafkaSpringConsumersGroupsTests {

	//internal publishers
	@Autowired
	private D5StringPublisher1 publisher1;

	@Autowired
	private D5StringPublisher2 publisher2;
	
	@Autowired
	private D5StringPublisher3 publisher3;

	//kafka
    @Autowired
    private D1KafkaProducer kafkaProducer;

    @Test
    public void testConsumerGroups() throws Exception {

    	//Given
    	D1Subscriber<String> subscriber1 = new D1Subscriber<>();
    	publisher1.addSubscriber(subscriber1);
    	D1Subscriber<String> subscriber2 = new D1Subscriber<>();
    	publisher2.addSubscriber(subscriber2);
    	D1Subscriber<String> subscriber3 = new D1Subscriber<>();
    	publisher3.addSubscriber(subscriber3);

    	//When
    	List<String> items = List.of("a1", "b2", "c3");
 	    items.forEach(i->kafkaProducer.send(D1Topics.TOPIC_5, i));
 	    Thread.sleep(2000);

	    //Then
	    List<String> actual1 = subscriber1.getConsumedElements().stream().sorted().collect(Collectors.toList());
	    List<String> actual2 = subscriber2.getConsumedElements().stream().sorted().collect(Collectors.toList());
	    List<String> actual3 = subscriber3.getConsumedElements().stream().sorted().collect(Collectors.toList());

	    Assert.assertEquals(items.size(), actual1.size() + actual2.size());
	    Assert.assertEquals(items.size(), actual3.size());
	    
	    List<String> actual12 = new ArrayList<>();
	    actual12.addAll(actual1);
	    actual12.addAll(actual2);

	    Assert.assertTrue(actual12.containsAll(items));
	    Assert.assertTrue(items.containsAll(actual12));
	    Assert.assertTrue(actual3.containsAll(items));
	    Assert.assertTrue(items.containsAll(actual3));
    }
}
