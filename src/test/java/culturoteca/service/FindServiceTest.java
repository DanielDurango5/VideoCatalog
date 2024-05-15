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
import static org.mockito.Mockito.doReturn;

public class FindServiceTest {
    private CultureMediaService cultureMediaService;
    private VideoRepository videoRepository = Mockito.mock();

    @BeforeEach
    void init() {
        videoRepository = Mockito.mock(VideoRepository.class);
        ViewsRepository viewsRepository = Mockito.mock(ViewsRepository.class);
        cultureMediaService = new CultureMediaServiceImpl(videoRepository, viewsRepository);

        List<Video> videos = List.of(
                new Video("01", "Título 1", "Horror", 1.5),
                new Video("02", "Título 2", "Comedy", 2.5),
                new Video("03", "Título 3", "Romance", 6.4),
                new Video("04", "Título 4", "Action", 1.3),
                new Video("05", "Clic 5", "Comedy", 2.7),
                new Video("06", "Clic 6", "Dramatic", 3.1));
        Mockito.when(videoRepository.findAll()).thenReturn(videos);
    }

    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() throws CulturotecaException {
        doReturn(List.of(new Video("05", "Clic 5", "Comedy", 2.7), new Video("06", "Clic 6", "Dramatic", 3.1)))
                .when(videoRepository)
                .find("Clic");
        List<Video> result = cultureMediaService.find("Clic");
        assertEquals(2, result.size());
    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        doReturn(List.of())
                .when(videoRepository)
                .find("video");
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.find("video"));
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() throws CulturotecaException {
        doReturn(List.of(new Video("01", "Título 1", "Horror", 1.5), new Video("02", "Título 2", "Comedy", 2.5), new Video("06", "Clic 6", "Dramatic", 3.1)))
                .when(videoRepository)
                .find(4.5, 5.5);
        List<Video> result = cultureMediaService.find(4.5, 5.5);
        assertEquals(3, result.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        doReturn(List.of())
                .when(videoRepository)
                .find(9.5, 10.5);
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.find(9.5, 10.5));
    }
}

