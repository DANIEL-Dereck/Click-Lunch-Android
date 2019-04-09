package fr.rennes.clicklunch.adapter;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.rennes.clicklunch.App;
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

            if (item.getProducts().get(0) != null && item.getProducts().get(0).getProductType() == ProductType.MENU) {
                foodListViewHolder.itemView.setBackgroundColor(ContextCompat.getColor(foodListViewHolder.itemView.getContext(), R.color.colorGreenMain));
            } else {
                foodListViewHolder.itemView.setBackgroundColor(ContextCompat.getColor(foodListViewHolder.itemView.getContext(), R.color.colorWhite));
            }

            // Set list of product.
            foodListViewHolder.getRv_food_list_products().setAdapter(new FoodDetailAdapter(item.getProducts()));
            foodListViewHolder.getRv_food_list_products().setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(App.getAppContext(), LinearLayoutManager.HORIZONTAL, false);
            foodListViewHolder.getRv_food_list_products().setLayoutManager(layoutManager);
        }
    }

    @Override
    public int getItemCount() {
        return this.foodList.size();
    }
}
