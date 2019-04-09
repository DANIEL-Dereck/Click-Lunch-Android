package fr.rennes.clicklunch.adapter;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.enums.ProductType;
import fr.rennes.clicklunch.utils.FoodListItem;
import fr.rennes.clicklunch.view_holder.FoodListViewHolder;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListViewHolder> {

    private List<FoodListItem> foodList;
    public FoodListAdapter() {
        this.foodList = new ArrayList<>();
    }

    public FoodListAdapter(List<FoodListItem> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewList = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_list_item, viewGroup, false);

        return new FoodListViewHolder(viewList);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListViewHolder foodListViewHolder, int i) {
        FoodListItem item = this.foodList.get(i);

        if (item.getProducts() != null && item.getProducts().size() > 0) {
            // Set title.
            foodListViewHolder.getTv_food_list_product_type().setText(item.getTitleString());

            // Get Color.
            int backgroundColor;

            if (item.getProducts().get(0) != null && item.getProducts().get(0).getProductType() == ProductType.MENU) {

                backgroundColor = ContextCompat.getColor(foodListViewHolder.itemView.getContext(), R.color.colorGreenMain);
                foodListViewHolder.itemView.setBackgroundColor(backgroundColor);
                foodListViewHolder.getTv_food_list_product_type().setTextColor(ContextCompat.getColor(foodListViewHolder.itemView.getContext(), R.color.colorBlack));
            } else {
                backgroundColor = ContextCompat.getColor(foodListViewHolder.itemView.getContext(), R.color.colorWhite);
                foodListViewHolder.itemView.setBackgroundColor(backgroundColor);
                foodListViewHolder.getTv_food_list_product_type().setTextColor(ContextCompat.getColor(foodListViewHolder.itemView.getContext(), R.color.colorOrangeText));
            }

            // Set list of product.
            FoodDetailAdapter foodDetailAdapter = new FoodDetailAdapter(item.getProducts(), backgroundColor);
            foodListViewHolder.getRv_food_list_products().setAdapter(foodDetailAdapter);
            foodListViewHolder.getRv_food_list_products().setHasFixedSize(true);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
            foodListViewHolder.getRv_food_list_products().setLayoutManager(staggeredGridLayoutManager);

            foodDetailAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return this.foodList.size();
    }
}
