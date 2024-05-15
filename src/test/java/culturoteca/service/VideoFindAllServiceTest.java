package culturoteca.service;

import culturoteca.exception.CulturotecaException;
import culturoteca.exception.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;
import culturoteca.repository.ViewsRepository;
import culturoteca.service.impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class VideoFindAllServiceTest {

    private CultureMediaService cultureMediaService;
    private VideoRepository videoRepository = Mockito.mock();

    @BeforeEach
    void init() {

        videoRepository = Mockito.mock(VideoRepository.class);
        ViewsRepository viewsRepository = Mockito.mock(ViewsRepository.class);
        cultureMediaService = new CultureMediaServiceImpl(videoRepository, viewsRepository);

        List<Video> videos = List.of(
                new Video("01", "ExampleTitle1", "Horror", 1.5),
                new Video("02", "ExampleTitle2", "Comedy", 2.5),
                new Video("03", "ExampleTitle3", "Romance", 6.4),
                new Video("04", "ExampleTitle4", "Action", 1.3),
                new Video("05", "ExampleTitle5", "Comedy", 2.7),
                new Video("06", "ExampleTitle6", "Dramatic", 3.1));

        when(videoRepository.findAll()).thenReturn(videos);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws CulturotecaException {
        init();
        List<Video> videos = cultureMediaService.findAllVideos();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        when(videoRepository.findAll()).thenReturn(List.of());
        VideoNotFoundException videoNotFoundException = assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findAllVideos();
        });
        assertEquals("Video not found", videoNotFoundException.getMessage());
    }
}