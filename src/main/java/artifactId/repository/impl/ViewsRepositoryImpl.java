package artifactId.repository.impl;

import artifactId.model.View;
import artifactId.repository.ViewsRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewsRepositoryImpl implements ViewsRepository {

    private final List<View> views;

    public ViewsRepositoryImpl() {
        this.views = new ArrayList<>();
    }

    @Override
    public View save(View view) {
        this.views.add( view );
        return view;
    }
}