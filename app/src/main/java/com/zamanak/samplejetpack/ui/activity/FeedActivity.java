package com.zamanak.samplejetpack.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.zamanak.samplejetpack.App;
import com.zamanak.samplejetpack.R;
import com.zamanak.samplejetpack.databinding.FeedActivityBinding;
import com.zamanak.samplejetpack.ui.adapter.FeedListAdapter;
import com.zamanak.samplejetpack.viewmodel.FeedViewModel;

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

        feedViewModel.getArticleLiveData().observe(this, pagedList -> {
            adapter.submitList(pagedList);
        });

        feedViewModel.getNetworkState().observe(this, networkState -> {
            adapter.setNetworkState(networkState);
        });

        binding.listFeed.setAdapter(adapter);
    }
}
