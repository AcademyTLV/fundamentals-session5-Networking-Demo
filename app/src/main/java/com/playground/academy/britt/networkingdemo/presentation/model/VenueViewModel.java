package com.playground.academy.britt.networkingdemo.presentation.model;

/**
 * Created by britt on 11/22/17.
 */

public class VenueViewModel {
    String id;
    String name;
    String imageUrl;

    public VenueViewModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
