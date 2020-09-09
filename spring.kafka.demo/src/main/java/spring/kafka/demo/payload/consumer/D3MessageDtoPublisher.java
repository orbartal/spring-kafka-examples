package spring.kafka.demo.payload.consumer;

import org.springframework.stereotype.Component;

import spring.kafka.demo.payload.model.MessageDto;
import spring.kafka.demo.simplest.consumer.D1MessagePublisher;

@Component
public class D3MessageDtoPublisher extends D1MessagePublisher<MessageDto> {}
