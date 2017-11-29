package com.playground.academy.britt.networkingdemo.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.playground.academy.britt.networkingdemo.R;
import com.playground.academy.britt.networkingdemo.presentation.model.VenueViewModel;

import java.util.List;

/**
 * Created by britt on 11/25/17.
 */

class VenuesAdapter extends RecyclerView.Adapter<VenueViewHolder> {

    List<VenueViewModel> venues;

    public VenuesAdapter(List<VenueViewModel> venues) {
        this.venues = venues;
    }

    @Override
    public VenueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_place, null);
        return new VenueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VenueViewHolder holder, int position) {
        holder.bindViewHolder(venues.get(position));

    }

    @Override
    public int getItemCount() {
        return venues == null ? 0 : venues.size();
    }

    public void setItems(List<VenueViewModel> venues) {
        this.venues = venues;
        notifyDataSetChanged();
    }

    public void setItem(int index, List<VenueViewModel> venues) {
        this.venues = venues;
        notifyItemChanged(index);
    }
}
