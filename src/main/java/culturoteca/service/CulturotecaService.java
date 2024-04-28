package culturoteca.service;

import culturoteca.exception.CulturotecaException;
import culturoteca.model.Video;
import culturoteca.model.View;

import java.util.List;

public interface CulturotecaService {
    List<Video> findAllVideos() throws CulturotecaException;
    Video add (Video video);
    View add (View view);

}
