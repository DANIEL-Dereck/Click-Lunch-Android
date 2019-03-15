package fr.rennes.clicklunch.adapter;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.entities.Shop;
import fr.rennes.clicklunch.utils.GPSTracker;
import fr.rennes.clicklunch.view_holder.ListShopViewHolder;

public class ListShopItemAdapter extends RecyclerView.Adapter<ListShopViewHolder> {

    public List<Shop> shops;
    public Location locUser;
    public ListShopItemAdapter() {
        this.shops = new ArrayList<>();
    }

    public ListShopItemAdapter(List<Shop> shops) {
        this.shops = new ArrayList<>();
        this.shops = shops;
    }

    @NonNull
    @Override
    public ListShopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewList = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_shop_item, viewGroup, false);

        this.locUser = new GPSTracker(viewGroup.getContext()).getLocation();

        return new ListShopViewHolder(viewList);
    }

    @Override
    public void onBindViewHolder(@NonNull ListShopViewHolder listShopViewHolder, int i) {
        Shop selectedShop = this.shops.get(i);
        String distance = "";

        Location locShop = new Location("Shop");
        locShop.setLatitude(selectedShop.getLatitude());
        locShop.setLongitude(selectedShop.getLongitude());

        if (locUser != null  && locShop != null) {
            int distanceBetween = (int)locUser.distanceTo(locShop);

            if (distanceBetween / 1000 >= 1) {
                distance = (distanceBetween / 1000) + "km";
            } else {
                distance = (int)locUser.distanceTo(locShop) + "m";
            }
        }

        // Set text data.
        listShopViewHolder.getTv_list_shop_item_name().setText(selectedShop.getName());
        listShopViewHolder.getTv_list_shop_item_category().setText(selectedShop.getCategoriesString());
        listShopViewHolder.getTv_list_shop_item_distance().setText(distance);

        // Clear image.
        listShopViewHolder.getIv_list_shop_item_image().setImageResource(0);
        listShopViewHolder.getIv_list_shop_item_image().setImageDrawable(null);
        listShopViewHolder.getIv_list_shop_item_image().setImageURI(null);

        // Set Image.
        if (selectedShop.getPhotos() != null && selectedShop.getPhotos().size() > 0 && selectedShop.getPhotos().get(0) != null) {
            Picasso.get().load(selectedShop.getPhotos().get(0).getPath()).into(listShopViewHolder.getIv_list_shop_item_image());
        }
    }

    @Override
    public int getItemCount() {
        return this.shops.size();
    }
}
