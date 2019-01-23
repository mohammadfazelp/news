package com.zamanak.samplejetpack;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.zamanak.samplejetpack.data.api.RestApi;
import com.zamanak.samplejetpack.data.api.RestApiFactory;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PIRI on 1/22/2019.
 */
public class App extends Application {

    private RestApi restApi;
    private Scheduler scheduler;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public static App create(Context context) {
        return App.get(context);
    }

    public RestApi getRestApi() {
        if (restApi == null) {
            restApi = RestApiFactory.create();
        }
        return restApi;
    }

    public void setRestApi(RestApi restApi) {
        this.restApi = restApi;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
