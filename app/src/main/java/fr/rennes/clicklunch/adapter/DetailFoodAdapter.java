package fr.rennes.clicklunch.adapter;

import android.content.Context;
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
import fr.rennes.clicklunch.utils.AppUtil;
import fr.rennes.clicklunch.view_holder.DetailFoodViewHolder;

public class DetailFoodAdapter extends RecyclerView.Adapter<DetailFoodViewHolder> {
    private List<Product> products;
    private Context context;

    public DetailFoodAdapter() {
        this.products  = new ArrayList<>();
    }

    public DetailFoodAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailFoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewList = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.detail_food_item, viewGroup, false);

        return new DetailFoodViewHolder(viewList);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailFoodViewHolder detailFoodViewHolder, int i) {
        final Product product = this.products.get(i);

        detailFoodViewHolder.getTv_detail_food_item_description().setText(product.getDescription());

        detailFoodViewHolder.getIv_detail_food_item_image().setImageResource(0);
        detailFoodViewHolder.getIv_detail_food_item_image().setImageDrawable(null);
        detailFoodViewHolder.getIv_detail_food_item_image().setImageURI(null);

        // Set Image.
        String url = AppUtil.NOIMG;

        if (product.getPhoto() != null) {
            url = product.getPhoto().getPath();
        }

        Picasso.get().load(url).placeholder(R.drawable.noimage).into(detailFoodViewHolder.getIv_detail_food_item_image());
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }
}
