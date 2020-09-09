package spring.kafka.demo.simplest.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
class D1KafkaTopicConfig {

  @Bean
  public NewTopic topic1() {
    return TopicBuilder.name(D1Topics.TOPIC_1).build();
  }
  @Bean
  public NewTopic topic2() {
    return TopicBuilder.name(D1Topics.TOPIC_2).build();
  }
  @Bean
  public NewTopic topic3() {
    return TopicBuilder.name(D1Topics.TOPIC_3).build();
  }
  @Bean
  public NewTopic topic4() {
    return TopicBuilder.name(D1Topics.TOPIC_4).build();
  }

}