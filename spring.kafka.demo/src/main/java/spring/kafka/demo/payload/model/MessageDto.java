package spring.kafka.demo.payload.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {

    private final String message;
    private final int identifier;

    public MessageDto(
    		@JsonProperty("identifier") final int identifier,
    		@JsonProperty("message") final String message
    		) {
        this.message = message;
        this.identifier = identifier;
    }

    public String getMessage() {
        return message;
    }

    public int getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "PracticalAdvice::toString() {" +
                "message='" + message + '\'' +
                ", identifier=" + identifier +
                '}';
    }
}