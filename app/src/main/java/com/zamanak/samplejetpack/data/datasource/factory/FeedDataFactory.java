package com.zamanak.samplejetpack.data.datasource.factory;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.zamanak.samplejetpack.App;
import com.zamanak.samplejetpack.data.datasource.FeedDataSource;

/**
 * Created by PIRI on 1/22/2019.
 */
public class FeedDataFactory extends DataSource.Factory {

    /*DataSourceFactory is responsible for retrieving the data
    using the DataSource and PagedList configuration which we
    create in our ViewModel class.*/

    private MutableLiveData<FeedDataSource> mutableLiveData;
    private FeedDataSource feedDataSource;
    private App app;

    public FeedDataFactory(App app) {
        this.app = app;
        this.mutableLiveData = new MutableLiveData<>();
    }

    @Override
    public DataSource create() {
        feedDataSource = new FeedDataSource(app);
        mutableLiveData.postValue(feedDataSource);
        return feedDataSource;
    }


    public MutableLiveData<FeedDataSource> getMutableLiveData() {
        return mutableLiveData;
    }
}