package fr.rennes.clicklunch.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.view_holder.FoodListViewHolder;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListViewHolder> {

    private String title;
    private ArrayList<ArrayList<Product>> foodList;

    public FoodListAdapter() {
        this.title = "";
        this.foodList = new ArrayList<>();
    }

    public FoodListAdapter(String title, ArrayList<ArrayList<Product>> foodList) {
        this.title = title;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListViewHolder foodListViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
