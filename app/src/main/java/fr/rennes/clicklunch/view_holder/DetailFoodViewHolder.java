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
public class DetailFoodViewHolder extends RecyclerView.ViewHolder {
    private ImageView iv_detail_food_item_image;
    private TextView tv_detail_food_item_description;

    public DetailFoodViewHolder(@NonNull View itemView) {
        super(itemView);

        this.iv_detail_food_item_image = itemView.findViewById(R.id.iv_detail_food_item_image);
        this.tv_detail_food_item_description = itemView.findViewById(R.id.tv_detail_food_item_description);
    }
}
