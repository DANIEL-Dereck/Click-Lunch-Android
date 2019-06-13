/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.adapter;

import android.location.Location;
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
import fr.rennes.clicklunch.utils.AppUtil;
import fr.rennes.clicklunch.view_holder.ListShopViewHolder;

public class ListShopItemAdapter extends RecyclerView.Adapter<ListShopViewHolder>{

    public List<Shop> shops;
    public Location locUser;
    private View.OnClickListener onClickListener;

    public ListShopItemAdapter() {
        this.shops = new ArrayList<>();
    }

    public ListShopItemAdapter(List<Shop> shops) {
        this.shops = new ArrayList<>();
        this.shops = shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public List<Shop> getShops() {
        return shops;
    }

    @NonNull
    @Override
    public ListShopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewList = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_shop_item, viewGroup, false);
        ListShopViewHolder viewHolder = new ListShopViewHolder(viewList);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(v);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListShopViewHolder listShopViewHolder, int i) {
        final Shop selectedShop = this.shops.get(i);

        Location locShop = new Location("Shop");
        locShop.setLatitude(selectedShop.getLatitude());
        locShop.setLongitude(selectedShop.getLongitude());

        String distance = "";//GPSTracker.getDistance(locShop);

        if (!distance.isEmpty()) {
            listShopViewHolder.getTv_list_shop_item_distance().setText(distance);
            listShopViewHolder.getTv_list_shop_item_distance().setVisibility(View.VISIBLE);
            listShopViewHolder.getTv_list_shop_item_category().setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
        } else {
            listShopViewHolder.getTv_list_shop_item_distance().setVisibility(View.GONE);
            listShopViewHolder.getTv_list_shop_item_category().setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }

        // Set text data.
        listShopViewHolder.getTv_list_shop_item_name().setText(selectedShop.getName());
        listShopViewHolder.getTv_list_shop_item_category().setText(selectedShop.getCategoriesString());

        // Clear image.
        listShopViewHolder.getIv_list_shop_item_image().setImageResource(0);
        listShopViewHolder.getIv_list_shop_item_image().setImageDrawable(null);
        listShopViewHolder.getIv_list_shop_item_image().setImageURI(null);

        // Set Image.
        String url = AppUtil.NOIMG;

        if (selectedShop.getPhotos() != null && selectedShop.getPhotos().size() > 0) {
            url = selectedShop.getPhotos().get(0).getUrl();
        }

        Picasso.get().load(url).placeholder(R.drawable.noimage).into(listShopViewHolder.getIv_list_shop_item_image());
    }

    @Override
    public int getItemCount() {
        return this.shops.size();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
