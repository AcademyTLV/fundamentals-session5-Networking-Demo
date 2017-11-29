package com.playground.academy.britt.networkingdemo.domain;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.playground.academy.britt.networkingdemo.data.MyCallback;
import com.playground.academy.britt.networkingdemo.data.VenuePhotosResponse;
import com.playground.academy.britt.networkingdemo.data.VenuesRepository;
import com.playground.academy.britt.networkingdemo.data.VenuesResponse;
import com.playground.academy.britt.networkingdemo.presentation.VenueListViewModel;
import com.playground.academy.britt.networkingdemo.presentation.model.VenueViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by britt on 11/22/17.
 */

public class GetVenues {
    VenuesRepository repository = VenuesRepository.get();
    GetVenuePhotos getVenuePhotos = new GetVenuePhotos();
    VenueListViewModel viewModel = new VenueListViewModel();

    public void execute(final MyCallback<VenueListViewModel> callback) {

        repository.getVenues(new MyCallback<VenuesResponse>() {
            @Override
            public void onSuccess(VenuesResponse data) {
                final List<VenueViewModel> venuesVM = createVenuesViewModel(data);

                viewModel.setVenues(venuesVM);
                callback.onSuccess(viewModel);

                getVenuePhotos(data, venuesVM);
            }

            private void getVenuePhotos(VenuesResponse data, final List<VenueViewModel> venuesVM) {
                for (VenuesResponse.Group group : data.getGroups()) {
                    for (int i = 0; i < group.getItems().size(); i++) {
                        MyCallback<VenuePhotosResponse> venuePhotosCallback = new MyCallback<VenuePhotosResponse>(i) {

                            @Override
                            public void onSuccess(VenuePhotosResponse venuePhotos) {
                                VenueViewModel venueViewModel = venuesVM.get(index);
                                if (venueViewModel == null) return;
                                String imageUrl = venuePhotos.getFirstUrl();
                                if (TextUtils.isEmpty(imageUrl)) return;
                                venueViewModel.setImageUrl(imageUrl);

                                callback.setIndex(index);
                                callback.onSuccess(viewModel);
                            }

                            @Override
                            public void onFailure() {

                            }

                        };

                        getVenuePhotos.execute(venuesVM.get(i), venuePhotosCallback);
                    }
                }
            }

            @Override
            public void onFailure() {
                callback.onFailure();
            }
        });
    }

    @NonNull
    private List<VenueViewModel> createVenuesViewModel(VenuesResponse data) {
        List<VenueViewModel> venuesVM = new ArrayList<>();

        for (VenuesResponse.Group group : data.getGroups()) {
            for (int i = 0; i < group.getItems().size(); i++) {
                VenuesResponse.Item item = group.getItems().get(i);
                VenueViewModel venueViewModel = new VenueViewModel(item.getVenue().getId(), item.getVenue().getName());
                venuesVM.add(venueViewModel);
            }
        }
        return venuesVM;
    }

}
