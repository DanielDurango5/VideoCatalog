package culturoteca.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CulturotecaException {

    public DurationNotValidException (String title, double duration){
        super(MessageFormat.format("No videos found with the title {0} and duration {1}", title, duration));
    }
}
