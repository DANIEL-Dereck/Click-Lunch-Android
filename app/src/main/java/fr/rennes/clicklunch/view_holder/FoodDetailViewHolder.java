/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.view_holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.rennes.clicklunch.R;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FoodDetailViewHolder extends RecyclerView.ViewHolder {
    private ImageView iv_food_detail_image;
    private TextView tv_food_detail_price;
    private TextView tv_food_detail_name;

    public FoodDetailViewHolder(@NonNull View itemView) {
        super(itemView);

        this.iv_food_detail_image = itemView.findViewById(R.id.iv_food_detail_image);
        this.tv_food_detail_price = itemView.findViewById(R.id.tv_food_detail_price);
        this.tv_food_detail_name = itemView.findViewById(R.id.tv_food_detail_name);
    }
}
