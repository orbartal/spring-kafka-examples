package spring.kafka.demo.consumers.groups.publishers;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.consumer.publisher.D1MessagePublisher;

@Component
public class D5StringPublisher1 extends D1MessagePublisher<String> {}
