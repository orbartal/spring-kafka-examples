package spring.kafka.demo.consumers.publishers;

import org.springframework.stereotype.Component;

import spring.kafka.demo.payload.model.MessageDto;
import spring.kafka.demo.simplest.consumer.D1MessagePublisher;

@Component
public class D4MessageDtoPublisher extends D1MessagePublisher<MessageDto> {}
