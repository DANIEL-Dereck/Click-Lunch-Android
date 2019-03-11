package fr.rennes.clicklunch.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.entities.Shop;
import fr.rennes.clicklunch.view_holder.ListShopViewHolder;

public class ListShopItemAdapter extends RecyclerView.Adapter<ListShopViewHolder> {

    List<Shop> shops;

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

        return new ListShopViewHolder(viewList);
    }

    @Override
    public void onBindViewHolder(@NonNull ListShopViewHolder listShopViewHolder, int i) {
        Shop selectedShop = this.shops.get(i);

        listShopViewHolder.getTv_list_shop_item_name().setText(selectedShop.getName());
        listShopViewHolder.getTv_list_shop_item_category().setText(selectedShop.getCategoriesString());
        listShopViewHolder.getTv_list_shop_item_distance().setText("200");
//        listShopViewHolder.getIv_list_shop_item_image();
    }

    @Override
    public int getItemCount() {
        return this.shops.size();
    }
}
