package com.faz.samplejetpack.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.faz.samplejetpack.App;
import com.faz.samplejetpack.R;
import com.faz.samplejetpack.databinding.FeedActivityBinding;
import com.faz.samplejetpack.ui.adapter.FeedListAdapter;
import com.faz.samplejetpack.viewmodel.FeedViewModel;

public class FeedActivity extends AppCompatActivity {

    private FeedListAdapter adapter;
    private FeedViewModel feedViewModel;
    private FeedActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_feed);

        feedViewModel = new FeedViewModel(App.create(this));

        binding.listFeed.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new FeedListAdapter(getApplicationContext());

        /*
         * When a new page is available, we call submitList() method
         * of the PagedListAdapter class
         */
        feedViewModel.getArticleLiveData().observe(this,
                pagedList -> adapter.submitList(pagedList));

        feedViewModel.getNetworkState().observe(this,
                networkState -> adapter.setNetworkState(networkState));

        binding.listFeed.setAdapter(adapter);
    }
}
