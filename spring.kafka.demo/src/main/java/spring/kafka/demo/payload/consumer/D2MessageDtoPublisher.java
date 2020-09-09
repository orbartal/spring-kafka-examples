package spring.kafka.demo.payload.consumer;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.consumer.publisher.D1MessagePublisher;
import spring.kafka.demo.common.model.MessageDto;

@Component
public class D2MessageDtoPublisher extends D1MessagePublisher<MessageDto> {}
