package spring.kafka.demo.consumers.publishers;

import org.springframework.stereotype.Component;

import spring.kafka.demo.simplest.consumer.D1MessagePublisher;

@Component
public class D4StringPublisher extends D1MessagePublisher<String> {}
