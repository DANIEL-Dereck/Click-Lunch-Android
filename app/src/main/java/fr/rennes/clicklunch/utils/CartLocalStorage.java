/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.rennes.clicklunch.entities.Order;
import fr.rennes.clicklunch.entities.OrderDetail;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.entities.Shop;
import fr.rennes.clicklunch.web_services.ws_entity.RetrofitOrder;
import fr.rennes.clicklunch.web_services.ws_entity.RetrofitOrderDetail;

public class CartLocalStorage {
    private static Order lastOrder;
    private static Shop shop;
    private static List<Product> products;
    private static CartLocalStorage instance;
    private static String hour;
    private static String minutes;
    private static Date recuperationDate;

    private CartLocalStorage() {
        products = new ArrayList<>();
    }

    public static CartLocalStorage getInstance() {
        if (instance == null) {
            instance = new CartLocalStorage();
        }

        if (products == null) {
            products = new ArrayList<>();
        }

        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
        }
    }

    public void setShop(Shop selectedShop) {
        shop = selectedShop;
    }

    public void setRecuperationHour(String recuperationHour, String recuperationMinutes) {
        hour = recuperationHour;
        minutes = recuperationMinutes;
        recuperationDate = new Date();
    }

    public List<Product> getAll() {
        return products;
    }

    public int countItems() {
        return products.size();
    }

    public void clear() {
        shop = null;
        products.clear();
        recuperationDate = new Date();
        hour = "";
        minutes = "";
    }

    public Order cartToOrder() {
        Order result = new Order();
        List<OrderDetail> lines = new ArrayList();

        for (Product product : products) {
            OrderDetail line = new OrderDetail();
            line.setProductId(product.getId());
            line.setQuantity(1);
            line.setProduct(product);
            line.setOrder(result);
            lines.add(line);
        }

        result.setRecoveryTime(recuperationDate);
        result.setOrderDetails(lines);

        lastOrder = result;
        return result;
    }

    public RetrofitOrder cartToRetrofitOrder() {
        RetrofitOrder newOrder = new RetrofitOrder();
        List<RetrofitOrderDetail> lines = new ArrayList();

        for (Product product : products) {
            if (!containId(lines, product.getId())) {
                RetrofitOrderDetail line = new RetrofitOrderDetail();
                line.setId(product.getId());
                line.setQuantity(countProductWithId(product.getId()));
                lines.add(line);
            }
        }

        newOrder.setProducts(lines);
        newOrder.setRecoveryTime(getHourString());

        cartToOrder();
        return newOrder;
    }

    public String getHourString() {
        return hour + ":" + minutes;
    }

    public String getShopName() {
        return shop.getName();
    }

    public int getShopId() {
        return shop.getId();
    }

    public Order getLastOrder() {
        return lastOrder;
    }

    public void setOrderNumber(String orderNumber) {
        if (orderNumber == null) {
            lastOrder.setNumber("UNKNOWN_ORDER_NUMBER");
        } else {
            lastOrder.setNumber(orderNumber);
        }
    }

    private int countProductWithId(int id) {
        int nb = 0;

        for (Product product : products) {
            if (product.getId() == id) {
                nb++;
            }
        }

        return nb;
    }

    private boolean containId(List<RetrofitOrderDetail> lines, int id) {
        boolean result = false;

        for (RetrofitOrderDetail line : lines) {
            if (line.getId() == id) {
                result = true;
                break;
            }
        }

        return result;
    }
}
