package com.playground.academy.britt.networkingdemo.network;

import com.playground.academy.britt.networkingdemo.data.VenuePhotosResponse;
import com.playground.academy.britt.networkingdemo.data.VenuesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by britt on 11/22/17.
 */

public interface FoursquareService {

    @GET("venues/explore")
    Call<VenuesResponse> getVenues(@Query("ll") String location);

    @GET("venues/{venueId}/photos")
    Call<VenuePhotosResponse> getVenuePhotos(@Path("venueId") String venueId);
}
