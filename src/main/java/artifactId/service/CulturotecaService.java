package artifactId.service;

import artifactId.model.Video;
import artifactId.model.View;

import java.util.List;

public interface CulturotecaService {
    List<Video> findAll();
    Video save (Video save);
    View reproduction (View reproduction);

}
