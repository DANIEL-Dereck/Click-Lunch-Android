/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.activity.CartActivity;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.utils.CartLocalStorage;
import fr.rennes.clicklunch.view_holder.CartItemViewHolder;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemViewHolder> {
    private List<Product> products;
    private Context context;

    public CartItemAdapter() {
        this.products = new ArrayList<>();
    }

    public CartItemAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewList = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cart_item, viewGroup, false);

        return new CartItemViewHolder(viewList);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder cartItemViewHolder, int i) {
        final Product product = this.products.get(i);

        cartItemViewHolder.getCart_item_name().setText(product.getName());
        cartItemViewHolder.getCart_item_price().setText(product.getPriceString() + " €");

        cartItemViewHolder.getIv_cart_remove().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartLocalStorage.getInstance().deleteProduct(product);
                ((CartActivity) context).updateTotal();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
