package fr.rennes.clicklunch.view_holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.rennes.clicklunch.R;
import lombok.Data;

@Data
public class ListShopViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_list_shop_item_name;
    private ImageView iv_list_shop_item_image;
    private TextView tv_list_shop_item_distance;
    private TextView tv_list_shop_item_category;

    public ListShopViewHolder(@NonNull View itemView) {
        super(itemView);

        this.tv_list_shop_item_name = itemView.findViewById(R.id.tv_list_shop_item_name);
        this.iv_list_shop_item_image = itemView.findViewById(R.id.iv_list_shop_item_image);
        this.tv_list_shop_item_distance = itemView.findViewById(R.id.tv_list_shop_item_distance);
        this.tv_list_shop_item_category = itemView.findViewById(R.id.tv_list_shop_item_category);
    }
}
