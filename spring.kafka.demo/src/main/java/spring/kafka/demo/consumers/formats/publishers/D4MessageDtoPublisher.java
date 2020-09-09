package spring.kafka.demo.consumers.formats.publishers;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.consumer.publisher.D1MessagePublisher;
import spring.kafka.demo.common.model.MessageDto;

@Component
public class D4MessageDtoPublisher extends D1MessagePublisher<MessageDto> {}
