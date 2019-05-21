package fr.rennes.clicklunch.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.activity.ProductDetailActivity;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.utils.AppUtil;
import fr.rennes.clicklunch.view_holder.FoodDetailViewHolder;

public class FoodDetailAdapter extends RecyclerView.Adapter<FoodDetailViewHolder> {
    private List<Product> products;
    private Context context;
    private int backgroundColor;

    public FoodDetailAdapter() {
        this.products  = new ArrayList<>();
    }

    public FoodDetailAdapter(List<Product> products, int backgroundColor, Context context) {
        this.products = products;
        this.backgroundColor = backgroundColor;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewList = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_item, viewGroup, false);

        return new FoodDetailViewHolder(viewList);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodDetailViewHolder foodDetailViewHolder, int i) {
        final Product product = this.products.get(i);

        // Set data.
        foodDetailViewHolder.getTv_food_detail_name().setText(product.getName());
        foodDetailViewHolder.getTv_food_detail_price().setText(product.getPriceString() + " €");

        // Clear image.
        foodDetailViewHolder.getIv_food_detail_image().setImageResource(0);
        foodDetailViewHolder.getIv_food_detail_image().setImageDrawable(null);
        foodDetailViewHolder.getIv_food_detail_image().setImageURI(null);
        foodDetailViewHolder.getIv_food_detail_image().setBackgroundColor(this.backgroundColor);

        // Set Image.
        String url = AppUtil.NOIMG;

        if (product.getPhoto() != null) {
            url = product.getPhoto().getPath();
        }

        Picasso.get().load(url).placeholder(R.drawable.noimage).into(foodDetailViewHolder.getIv_food_detail_image());

        foodDetailViewHolder.getIv_food_detail_image().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context != null) {
                    Intent intent = new Intent((Activity) context, ProductDetailActivity.class);
                    intent.putExtra(ProductDetailActivity.EXTRA_PRODUCT, product);
                    ((Activity) context).startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }
}
