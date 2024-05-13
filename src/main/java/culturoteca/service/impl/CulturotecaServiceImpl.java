package culturoteca.service.impl;

import culturoteca.exception.CulturotecaException;
import culturoteca.exception.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.model.View;
import culturoteca.repository.VideoRepository;
import culturoteca.repository.ViewsRepository;
import culturoteca.service.CulturotecaService;

import java.util.List;

public class CulturotecaServiceImpl implements CulturotecaService {
    VideoRepository videoRepository;
    ViewsRepository viewsRepository;

    public CulturotecaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {

        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public List<Video> findAllVideos() throws CulturotecaException {
        List<Video> videoList = videoRepository.findAll();
        if (videoList.isEmpty()){
            throw new VideoNotFoundException();
        }else{
           return videoList;
        }
    }

    @Override
    public List<Video> find(String title) throws CulturotecaException {
        List<Video> filteredVideos = videoRepository.find(title);
        if (filteredVideos.isEmpty()){
            throw new VideoNotFoundException();
        }else{
            return filteredVideos;
        }
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) throws CulturotecaException {
        List<Video> filteredVideos = videoRepository.find(fromDuration, toDuration);
        if (filteredVideos.isEmpty()) {
            throw new VideoNotFoundException();
        } else {
            return filteredVideos;
        }
    }

    @Override
    public Video add(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public View add(View view) {
        return viewsRepository.save(view);
    }
    }


