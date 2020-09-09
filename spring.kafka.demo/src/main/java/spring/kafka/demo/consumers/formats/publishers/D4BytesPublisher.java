package spring.kafka.demo.consumers.formats.publishers;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.consumer.publisher.D1MessagePublisher;

@Component
public class D4BytesPublisher extends D1MessagePublisher<byte[]> {}
