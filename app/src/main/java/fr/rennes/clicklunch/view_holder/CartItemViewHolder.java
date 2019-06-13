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
public class CartItemViewHolder extends RecyclerView.ViewHolder {

    private TextView cart_item_name;
    private TextView cart_item_price;
    private ImageView iv_cart_remove;

    public CartItemViewHolder(@NonNull View itemView) {
        super(itemView);

        this.cart_item_name = itemView.findViewById(R.id.cart_item_name);
        this.cart_item_price = itemView.findViewById(R.id.cart_item_price);
        this.iv_cart_remove = itemView.findViewById(R.id.iv_cart_remove);
    }
}
