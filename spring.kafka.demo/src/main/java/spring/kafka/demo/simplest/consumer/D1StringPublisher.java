package spring.kafka.demo.simplest.consumer;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.consumer.publisher.D1MessagePublisher;

@Component
public class D1StringPublisher extends D1MessagePublisher<String> {}
