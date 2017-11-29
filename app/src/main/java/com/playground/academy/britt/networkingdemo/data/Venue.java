package com.playground.academy.britt.networkingdemo.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by britt on 11/22/17.
 */

public class Venue {
    String id;

    String name;

    @SerializedName("contact")
    ContactInfo contact;

    String rating;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private class ContactInfo {
        String phone;
        String formattedPhone;

        public String getPhone() {
            return phone;
        }

        public String getFormattedPhone() {
            return formattedPhone;
        }
    }

    public ContactInfo getContact() {
        return contact;
    }

    public String getRating() {
        return rating;
    }
}
