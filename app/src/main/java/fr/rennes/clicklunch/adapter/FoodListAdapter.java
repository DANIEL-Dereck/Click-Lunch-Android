/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.adapter;

import android.content.Context;
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
    private Context context;

    public FoodListAdapter() {
        this.foodList = new ArrayList<>();
    }

    public FoodListAdapter(List<FoodListItem> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
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

        if (item.getProducts() == null || item.getProducts().size() <= 0) {
            foodListViewHolder.getRv_food_list_products().setVisibility(View.GONE);
            foodListViewHolder.getTv_food_list_product_type().setVisibility(View.GONE);
        } else {
            foodListViewHolder.getRv_food_list_products().setVisibility(View.VISIBLE);
            foodListViewHolder.getTv_food_list_product_type().setVisibility(View.VISIBLE);
        }

        // Set title.
            foodListViewHolder.getTv_food_list_product_type().setText(item.getTitleString());

            // Get Color.
            int backgroundColor;

            if (item != null && item.getProducts().size() > 0 && item.getProducts().get(0) != null && item.getProducts().get(0).getProductType() == ProductType.MENU) {
                backgroundColor = ContextCompat.getColor(foodListViewHolder.itemView.getContext(), R.color.colorGreenMain);
                foodListViewHolder.itemView.setBackgroundColor(backgroundColor);
                foodListViewHolder.getTv_food_list_product_type().setTextColor(ContextCompat.getColor(foodListViewHolder.itemView.getContext(), R.color.colorBlack));
            } else {
                backgroundColor = ContextCompat.getColor(foodListViewHolder.itemView.getContext(), R.color.colorWhite);
                foodListViewHolder.itemView.setBackgroundColor(backgroundColor);
                foodListViewHolder.getTv_food_list_product_type().setTextColor(ContextCompat.getColor(foodListViewHolder.itemView.getContext(), R.color.colorOrangeText));
            }

            // Set list of product.
            FoodDetailAdapter foodDetailAdapter = new FoodDetailAdapter(item.getProducts(), backgroundColor, context);
            foodListViewHolder.getRv_food_list_products().setAdapter(foodDetailAdapter);
            foodListViewHolder.getRv_food_list_products().setHasFixedSize(true);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
            foodListViewHolder.getRv_food_list_products().setLayoutManager(staggeredGridLayoutManager);

            foodDetailAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.foodList.size();
    }
}
