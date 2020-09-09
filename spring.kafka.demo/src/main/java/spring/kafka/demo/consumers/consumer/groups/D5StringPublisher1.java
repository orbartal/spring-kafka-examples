package spring.kafka.demo.consumers.consumer.groups;

import org.springframework.stereotype.Component;

import spring.kafka.demo.simplest.consumer.D1MessagePublisher;

@Component
public class D5StringPublisher1 extends D1MessagePublisher<String> {}
