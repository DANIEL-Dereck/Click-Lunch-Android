package fr.rennes.clicklunch.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.utils.AppUtils;
import fr.rennes.clicklunch.utils.GPSTracker;
import fr.rennes.clicklunch.view_holder.FoodDetailViewHolder;
import fr.rennes.clicklunch.view_holder.ListShopViewHolder;

public class FoodDetailAdapter extends RecyclerView.Adapter<FoodDetailViewHolder> {
    private List<Product> products;

    public FoodDetailAdapter() {
        this.products  = new ArrayList<>();
    }
    public int backgroundColor;

    public FoodDetailAdapter(List<Product> products, int backgroundColor) {
        this.products = products;
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public FoodDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewList = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_detail_item, viewGroup, false);

        return new FoodDetailViewHolder(viewList);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodDetailViewHolder foodDetailViewHolder, int i) {
        Product product = this.products.get(i);

        // Set data.
        foodDetailViewHolder.getTv_food_detail_name().setText(product.getName());
        foodDetailViewHolder.getTv_food_detail_price().setText(product.getPriceString() + " €");

        // Clear image.
        foodDetailViewHolder.getIv_food_detail_image().setImageResource(0);
        foodDetailViewHolder.getIv_food_detail_image().setImageDrawable(null);
        foodDetailViewHolder.getIv_food_detail_image().setImageURI(null);
        foodDetailViewHolder.getIv_food_detail_image().setBackgroundColor(this.backgroundColor);

        // Set Image
        if (product.getPhoto() != null) {
            Picasso.get().load(product.getPhoto().getPath()).into(foodDetailViewHolder.getIv_food_detail_image());
        } else {
            Picasso.get().load(AppUtils.NOIMG).into(foodDetailViewHolder.getIv_food_detail_image());
        }
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }
}
