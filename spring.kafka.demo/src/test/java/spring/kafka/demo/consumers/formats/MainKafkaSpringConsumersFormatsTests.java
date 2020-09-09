package spring.kafka.demo.consumers.formats;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring.kafka.demo.common.config.C1Topics;
import spring.kafka.demo.common.model.MessageDto;
import spring.kafka.demo.consumers.formats.publishers.D4BytesPublisher;
import spring.kafka.demo.consumers.formats.publishers.D4MessageDtoPublisher;
import spring.kafka.demo.consumers.formats.publishers.D4StringPublisher;
import spring.kafka.demo.payload.producer.D2KafkaProducer;
import spring.kafka.demo.simplest.D1Subscriber;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainKafkaSpringConsumersFormatsTests {

	//internal publishers
	@Autowired
	private D4BytesPublisher bytesMessagePublisher;

	@Autowired
	private D4StringPublisher stringMessagePublisher;
	
	@Autowired
	private D4MessageDtoPublisher dtoMessagePublisher;

	//kafka
    @Autowired
    private D2KafkaProducer kafkaProducer;

    @Test
    public void test1() throws Exception {

    	//Given
    	D1Subscriber<byte[]> subscriber1 = new D1Subscriber<>();
    	bytesMessagePublisher.addSubscriber(subscriber1);
    	D1Subscriber<String> subscriber2 = new D1Subscriber<>();
    	stringMessagePublisher.addSubscriber(subscriber2);
    	D1Subscriber<MessageDto> subscriber3 = new D1Subscriber<>();
    	dtoMessagePublisher.addSubscriber(subscriber3);

    	//When
    	int size = 3;
	    List<String> items = List.of("a", "b", "c");
	    IntStream.range(0, size).forEach(i->kafkaProducer.send(C1Topics.TOPIC_4, new MessageDto(i, items.get(i))));
	    List<String> expected = IntStream.range(0, size).boxed().map(i->new MessageDto(i, items.get(i)).toJson()).sorted().collect(Collectors.toList());
	    Thread.sleep(5000);

	    //Then
	    List<String> actual1 = subscriber1.getConsumedElements().stream().map(b->new String(b)).sorted().collect(Collectors.toList());
	    List<String> actual2 = subscriber2.getConsumedElements().stream().sorted().collect(Collectors.toList());
	    List<String> actual3 = subscriber3.getConsumedElements().stream().map(d->d.toJson()).sorted().collect(Collectors.toList());

	    Assert.assertEquals(expected.size(), actual1.size());
	    Assert.assertEquals(expected.size(), actual2.size());
	    Assert.assertEquals(expected.size(), actual3.size());

	    Assert.assertTrue(actual1.containsAll(expected));
	    Assert.assertTrue(expected.containsAll(actual1));
	    Assert.assertTrue(actual2.containsAll(expected));
	    Assert.assertTrue(expected.containsAll(actual2));
	    Assert.assertTrue(actual3.containsAll(expected));
	    Assert.assertTrue(expected.containsAll(actual3));

    }
}
