package com.playground.academy.britt.networkingdemo.domain;

import com.playground.academy.britt.networkingdemo.data.MyCallback;
import com.playground.academy.britt.networkingdemo.data.VenuePhotosResponse;
import com.playground.academy.britt.networkingdemo.data.VenuePhotosRepository;
import com.playground.academy.britt.networkingdemo.presentation.model.VenueViewModel;

/**
 * Created by britt on 11/25/17.
 */

public class GetVenuePhotos {
    VenuePhotosRepository repository = VenuePhotosRepository.get();


    public void execute(VenueViewModel venueViewModel, MyCallback<VenuePhotosResponse> itemChangedCallback) {
        repository.getVenuePhotos(venueViewModel.getId(), itemChangedCallback);

    }
}
