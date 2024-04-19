package artifactId.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends Exception{

    public VideoNotFoundException (String title){
        super(MessageFormat.format("Invalid tittle for the video {0}", title));
    }
}
