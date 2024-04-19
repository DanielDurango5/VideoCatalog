package artifactId.model;

import org.apache.logging.log4j.message.StringFormattedMessage;

public record Video(String code, String title, String description, Double duration) {
}