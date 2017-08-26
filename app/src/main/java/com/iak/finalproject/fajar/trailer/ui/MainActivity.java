package com.iak.finalproject.fajar.trailer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.iak.finalproject.fajar.trailer.R;
import com.iak.finalproject.fajar.trailer.model.MovieResponse;
import com.iak.finalproject.fajar.trailer.network.NetworkManager;

public class MainActivity extends AppCompatActivity
        implements NetworkManager.NetworkCallback {

    public static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();

        NetworkManager.getPopularMovie(1, this);
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Throwable throwable) {
        Log.e(TAG, "Fail", throwable);
    }

    @Override
    public void onSuccess(MovieResponse movieResponse) {
        adapter.setItems(movieResponse.getResults());
    }
}
