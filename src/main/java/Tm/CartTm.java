package Tm;

import com.jfoenix.controls.JFXButton;

public class CartTm {
    private String OrderID;
    private String CustomerID;
    private String ItemID;
    private String ItemName;
    private int ItemPrice;
    private String ItemQuantity;
    private int total;
    private JFXButton btnRemove;

    public JFXButton getBtnRemove() {
        return btnRemove;
    }

    public void setBtnRemove(JFXButton btnRemove) {
        this.btnRemove = btnRemove;
    }

    public CartTm(String orderID, String customerID, String itemID, String itemName, int itemPrice, String itemQuantity, int total, JFXButton btnRemove) {
        OrderID = orderID;
        CustomerID = customerID;
        ItemID = itemID;
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemQuantity = itemQuantity;
        this.total = total;
        this.btnRemove = btnRemove;
    }

    public CartTm() {
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(int itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        ItemQuantity = itemQuantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
