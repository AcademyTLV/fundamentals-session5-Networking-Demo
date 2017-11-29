package com.playground.academy.britt.networkingdemo.network;

import com.playground.academy.britt.networkingdemo.data.MyCallback;
import com.playground.academy.britt.networkingdemo.data.VenuePhotosResponse;
import com.playground.academy.britt.networkingdemo.data.VenuesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by britt on 11/22/17.
 */

public class AppNetworkClient {
    static AppNetworkClient instance = new AppNetworkClient();

    public static AppNetworkClient get() {
        return instance;
    }

    public void getVenues(final MyCallback<VenuesResponse> callback) {
        String location = "32.070080,34.794145";
        Call<VenuesResponse> call = ServiceGenerator.getFoursquareService().getVenues(location);

        call.enqueue(new Callback<VenuesResponse>() {
            @Override
            public void onResponse(Call<VenuesResponse> call, Response<VenuesResponse> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<VenuesResponse> call, Throwable t) {
                callback.onFailure();
            }
        });

    }

    public void getVenuePhotos(String venueId, final MyCallback<VenuePhotosResponse> callback) {
        Call<VenuePhotosResponse> call = ServiceGenerator.getFoursquareService().getVenuePhotos(venueId);

        call.enqueue(new Callback<VenuePhotosResponse>() {
            @Override
            public void onResponse(Call<VenuePhotosResponse> call, Response<VenuePhotosResponse> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<VenuePhotosResponse> call, Throwable t) {
                callback.onFailure();
            }
        });
    }
}
