package culturoteca.service;

import culturoteca.exception.CulturotecaException;
import culturoteca.model.Video;
import culturoteca.model.View;

import java.util.List;

public interface CultureMediaService {
    List<Video> findAll() throws CulturotecaException;

    List<Video> find(String title) throws CulturotecaException;

    List<Video> find(Double fromDuration, Double toDuration) throws CulturotecaException;

    Video add (Video video);
    View add (View view);

}
