package fr.rennes.clicklunch.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.view_holder.FoodDetailViewHolder;

public class FoodDetailAdapter extends RecyclerView.Adapter<FoodDetailViewHolder> {
    private ArrayList<Product> products;

    public FoodDetailAdapter() {
        this.products  = new ArrayList<>();
    }

    @NonNull
    @Override
    public FoodDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodDetailViewHolder foodDetailViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
