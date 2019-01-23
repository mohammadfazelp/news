package com.zamanak.samplejetpack.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.zamanak.samplejetpack.App;
import com.zamanak.samplejetpack.data.datasource.factory.FeedDataFactory;
import com.zamanak.samplejetpack.data.model.Article;
import com.zamanak.samplejetpack.utils.NetworkState;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FeedViewModel extends ViewModel {


    private Executor executor;
    private LiveData networkState;
    private LiveData articleLiveData;


    private App appController;

    public FeedViewModel(@NonNull App appController) {
        this.appController = appController;
        init();
    }

    private void init() {
        executor = Executors.newFixedThreadPool(5);

        FeedDataFactory feedDataFactory = new FeedDataFactory(appController);
        networkState = Transformations.switchMap(feedDataFactory.getMutableLiveData(),
                dataSource -> dataSource.getNetworkState());

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(10)
                        .setPageSize(20).build();

        articleLiveData = (new LivePagedListBuilder(feedDataFactory, pagedListConfig))
                .setFetchExecutor(executor)
                .build();
    }


    public LiveData<NetworkState> getNetworkState() {
        return networkState;
    }

    public LiveData<PagedList<Article>> getArticleLiveData() {
        return articleLiveData;
    }
}
