package fr.rennes.clicklunch.view_holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.rennes.clicklunch.R;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FoodListViewHolder extends RecyclerView.ViewHolder {
    private TextView tv_food_list_product_type;
    private RecyclerView rv_food_list_products;

    public FoodListViewHolder(@NonNull View itemView) {
        super(itemView);

        this.tv_food_list_product_type = itemView.findViewById(R.id.tv_food_list_product_type);
        this.rv_food_list_products = itemView.findViewById(R.id.rv_food_list_products);
    }
}
