package culturoteca.controllers;

import java.util.Collections;
import java.util.List;

import culturoteca.exception.CulturotecaException;
import culturoteca.exception.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.service.CultureMediaService;
import culturoteca.service.impl.CultureMediaServiceImpl;

public class CultureMediaController {

    private final CultureMediaService cultureMediaService;
    
    public CultureMediaController(CultureMediaServiceImpl cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }
    public List<Video> find_allVideos() throws CulturotecaException {
        List<Video> videos = null;
        return videos = cultureMediaService.findAllVideos();
    }
}
