package com.playground.academy.britt.networkingdemo.data;

import com.playground.academy.britt.networkingdemo.network.AppNetworkClient;
import com.playground.academy.britt.networkingdemo.network.FoursquareService;
import com.playground.academy.britt.networkingdemo.network.ServiceGenerator;

/**
 * Created by britt on 11/22/17.
 */

public class VenuePhotosRepository {
    static VenuePhotosRepository instance;
    AppNetworkClient client = AppNetworkClient.get();
    FoursquareService foursquareService = ServiceGenerator.getFoursquareService();

    public static VenuePhotosRepository get() {
        if (instance == null) {
            instance = new VenuePhotosRepository();
        }
        return instance;
    }

    public void getVenuePhotos(final String venueId, final MyCallback<VenuePhotosResponse> callback) {
        client.getVenuePhotos(venueId, callback);
    }

}
