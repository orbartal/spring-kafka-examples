package spring.kafka.demo.payload;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring.kafka.demo.common.config.C1Topics;
import spring.kafka.demo.common.model.MessageDto;
import spring.kafka.demo.payload.consumer.D2MessageDtoPublisher;
import spring.kafka.demo.payload.producer.D2KafkaProducer;
import spring.kafka.demo.simplest.D1Subscriber;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainKafkaSpringPayloadTests {

	@Autowired
	private D2MessageDtoPublisher internalPublisher;

    @Autowired
    private D2KafkaProducer kafkaProducer;

    @Test
    public void testPayload() throws Exception {

    	//Given
    	D1Subscriber<MessageDto> subscriber = new D1Subscriber<>();
    	internalPublisher.addSubscriber(subscriber);

    	//When
	    List<String> items = List.of("a1", "b2", "c3");
	    items.forEach(i->kafkaProducer.send(C1Topics.TOPIC_2, new MessageDto(1, i)));
	    Thread.sleep(2000);

	    //Then
	    List<String> actual = subscriber.getConsumedElements().stream().map(p->p.getMessage()).collect(Collectors.toList());
	    Assert.assertTrue(actual.containsAll(items));
	    Assert.assertTrue(items.containsAll(actual));
    }
}
