package com.playground.academy.britt.networkingdemo.data;

import java.util.List;

/**
 * Created by britt on 11/22/17.
 */

public class VenuesResponse {
    List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public static class Group {
        List<Item> items;

        public List<Item> getItems() {
            return items;
        }
    }

    public static class Item {
        Venue venue;

        public Venue getVenue() {
            return venue;
        }
    }
}
