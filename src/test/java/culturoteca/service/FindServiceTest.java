package culturoteca.service;

import culturoteca.exception.CulturotecaException;
import culturoteca.exception.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;
import culturoteca.repository.ViewsRepository;
import culturoteca.repository.impl.ViewsRepositoryImpl;
import culturoteca.service.impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

public class FindServiceTest {
    private CultureMediaService culturotecaService;
    private final VideoRepository videoRepository = Mockito.mock();

     Video newVideo1 = new Video("01", "Título 1", "----", 4.5);
     Video newVideo2  = new Video("02", "Título 2", "----", 5.5);
     Video newVideo3  = new Video("03", "Título 3", "----", 4.4);
     Video newVideo4  = new Video("04", "Título 4", "----", 3.5);
     Video newVideo5  = new Video("05", "Clic 5", "----", 5.7);
     Video newVideo6  = new Video("06", "Clic 6", "----", 5.1);

    @BeforeEach
    void unit(){
        ViewsRepository viewsRepository = new ViewsRepositoryImpl();
        culturotecaService = new CultureMediaServiceImpl(videoRepository, viewsRepository);
    }


    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() throws CulturotecaException {
        doReturn(List.of(newVideo5, newVideo6))
                .when(videoRepository)
                .find("Clic");
    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        VideoNotFoundException videoNotFoundException = assertThrows(VideoNotFoundException.class, () -> {
            culturotecaService.find("video");
        });
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() throws CulturotecaException {
        doReturn(List.of(newVideo1, newVideo2, newVideo6))
                .when(videoRepository)
                .find(4.5,5.5);
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully(){
        VideoNotFoundException videoNotFoundException = assertThrows(VideoNotFoundException.class, () -> {
            culturotecaService.find(9.5,10.5);
        });
    }
}
