package artifactId.model;

import org.apache.logging.log4j.message.StringFormattedMessage;

public class Video {

    String code;
    String title;
    String description;
    double duration;

    public Video(){
    }

    public Video(String code, String title, String description, double duration) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
