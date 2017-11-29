package com.playground.academy.britt.networkingdemo.data;

import com.playground.academy.britt.networkingdemo.network.AppNetworkClient;
import com.playground.academy.britt.networkingdemo.network.FoursquareService;
import com.playground.academy.britt.networkingdemo.network.ServiceGenerator;

/**
 * Created by britt on 11/22/17.
 */

public class VenuesRepository {
    static VenuesRepository instance;
    AppNetworkClient client = AppNetworkClient.get();
    FoursquareService foursquareService = ServiceGenerator.getFoursquareService();

    public static VenuesRepository get() {
        if (instance == null) {
            instance = new VenuesRepository();
        }
        return instance;
    }

    public void getVenues(final MyCallback<VenuesResponse> callback) {
        client.getVenues(callback);
    }

}
