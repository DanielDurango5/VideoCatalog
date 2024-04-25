package culturoteca.service;

import culturoteca.model.Video;
import culturoteca.model.View;

import java.util.List;

public interface CulturotecaService {
    List<Video> findAll();
    Video save (Video save);
    View reproduction (View reproduction);

}
