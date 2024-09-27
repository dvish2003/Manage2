package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class OrderDetailEntity {
    @Id
    private String OrderID;
    private String Item;
    private int Qty;
    private int Price;

    public OrderDetailEntity(String orderID, String item, int qty, int price) {
        OrderID = orderID;
        Item = item;
        Qty = qty;
        Price = price;
    }

    public OrderDetailEntity() {

    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
