package spring.kafka.demo.common.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class FutureProducerCallBack<K, U> implements ListenableFutureCallback<SendResult<K, U>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(FutureProducerCallBack.class);

	private String topic;
	private String message;

	public FutureProducerCallBack(String topic, String message) {
		this.topic = topic;
		this.message = message;
	}

	@Override
	public void onSuccess(SendResult<K, U> result) {
		LOGGER.info("sent message='{}' to topic='{}' with offset={}", message, topic, result.getRecordMetadata().offset());
	}

	@Override
	public void onFailure(Throwable ex) {
		LOGGER.error("unable to send message='{}' to topic='{}'", message, topic, ex);
	}
	
}
