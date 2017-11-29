package com.playground.academy.britt.networkingdemo.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.playground.academy.britt.networkingdemo.R;
import com.playground.academy.britt.networkingdemo.data.MyCallback;
import com.playground.academy.britt.networkingdemo.domain.GetVenues;

/**
 * Created by britt on 11/22/17.
 */

public class MainActivity extends AppCompatActivity {

    VenueListViewModel viewModel;
    RecyclerView recyclerView;
    VenuesAdapter adapter;
    GetVenues getVenues;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_places);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new VenuesAdapter(null);
        recyclerView.setAdapter(adapter);

        getVenues = new GetVenues();
        final MyCallback<VenueListViewModel> venuesViewModelMyCallback = new MyCallback<VenueListViewModel>() {

            @Override
            public void onSuccess(VenueListViewModel viewModel) {
                MainActivity.this.viewModel = viewModel;
                if (index >= 0) {
                    adapter.setItem(index, MainActivity.this.viewModel.getVenues());
                } else {
                    adapter.setItems(viewModel.getVenues());
                }
            }

            @Override
            public void onFailure() {

            }
        };

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                getVenues.execute(venuesViewModelMyCallback);

            }

            ;
        });

    }
}
