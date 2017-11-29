package com.playground.academy.britt.networkingdemo.domain;

import com.playground.academy.britt.networkingdemo.data.MyCallback;
import com.playground.academy.britt.networkingdemo.data.VenuesRepository;
import com.playground.academy.britt.networkingdemo.data.VenuesResponse;
import com.playground.academy.britt.networkingdemo.presentation.VenueListViewModel;
import com.playground.academy.britt.networkingdemo.presentation.model.VenueViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by britt on 11/22/17.
 */

public class GetVenues_base {
    VenuesRepository repository = VenuesRepository.get();

    public void execute(final MyCallback<VenueListViewModel> callback) {

        repository.getVenues(new MyCallback<VenuesResponse>() {
            @Override
            public void onSuccess(VenuesResponse data) {
                callback.onSuccess(createViewModel(data));

            }

            @Override
            public void onFailure() {

            }
        });
    }

    private VenueListViewModel createViewModel(VenuesResponse response) {
        List<VenueViewModel> venueVM = new ArrayList<>();

        for (VenuesResponse.Group group : response.getGroups()) {
            for (VenuesResponse.Item item : group.getItems()) {
                VenueViewModel venueViewModel = new VenueViewModel(item.getVenue().getId(), item.getVenue().getName());
                venueVM.add(venueViewModel);
            }
        }
        return new VenueListViewModel(venueVM);

    }
}
