package culturoteca.controllers;

import java.util.Collections;
import java.util.List;

import culturoteca.exception.CulturotecaException;
import culturoteca.model.Video;
import culturoteca.repository.impl.VideoRepositoryImpl;
import culturoteca.repository.impl.ViewsRepositoryImpl;
import culturoteca.service.CultureMediaService;
import culturoteca.service.impl.CultureMediaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CultureMediaController {

    private final CultureMediaService cultureMediaService;
    
    public CultureMediaController(CultureMediaServiceImpl cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public CultureMediaController() {
        this.cultureMediaService = new CultureMediaServiceImpl(new VideoRepositoryImpl(), new ViewsRepositoryImpl());
    }

    @GetMapping("/videos")
    public ResponseEntity<List<Video>> findAllVideos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cultureMediaService.findAll());
        } catch (CulturotecaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Error-Message", e.getMessage())
                    .body(Collections.emptyList());
        }
    }

    @PostMapping("/videos")
    public Video addVideo(@RequestBody Video video){
        return cultureMediaService.add(video);
    }
}
