package artifactId.model;

import java.time.LocalDateTime;

public class View {

    String userFullName;
    LocalDateTime startPlayingTime;
    Integer age;
    Video video;

    public View() {
    }

    public View(String userFullName, LocalDateTime startPlayingTime, Integer age, Video video) {
        this.userFullName = userFullName;
        this.startPlayingTime = startPlayingTime;
        this.age = age;
        this.video = video;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public LocalDateTime getStartPlayingTime() {
        return startPlayingTime;
    }

    public void setStartPlayingTime(LocalDateTime startPlayingTime) {
        this.startPlayingTime = startPlayingTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
