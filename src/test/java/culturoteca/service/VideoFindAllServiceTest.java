package culturoteca.service;

import culturoteca.exception.CulturotecaException;
import culturoteca.exception.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;
import culturoteca.repository.ViewsRepository;
import culturoteca.repository.impl.VideoRepositoryImpl;
import culturoteca.repository.impl.ViewsRepositoryImpl;
import culturoteca.service.impl.CulturotecaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VideoFindAllServiceTest {

    private CulturotecaService culturotecaService;

    @BeforeEach
    void init(){
        VideoRepository videoRepository = new VideoRepositoryImpl();
        ViewsRepository viewsRepository = new ViewsRepositoryImpl();
        culturotecaService = new CulturotecaServiceImpl(videoRepository, viewsRepository);
    }

    private void listVideos(){
        List<Video> videos = List.of(
                new Video("01", "ExampleTitle1", "Horror", 1.5),
                new Video("02", "ExampleTitle2", "Comedy", 2.5),
                new Video("03", "ExampleTitle3", "Romance", 6.4),
                new Video("04", "ExampleTitle4", "Action", 1.3),
                new Video("05", "ExampleTitle5", "Comedy", 2.7),
                new Video("06", "ExampleTitle6", "Dramatic", 3.1));

        for(Video video : videos){
            culturotecaService.add(video);
        }
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws CulturotecaException {
        listVideos();
        List<Video> videos = culturotecaService.findAllVideos();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws CulturotecaException {
        VideoNotFoundException videoNotFoundException = assertThrows(VideoNotFoundException.class, () ->{
            culturotecaService.findAllVideos();
    });
    }
}
