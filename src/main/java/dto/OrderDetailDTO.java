package dto;

public class OrderDetailDTO {
    private String OrderID;
    private String Item;
    private String Qty;
    private int Price;

    public OrderDetailDTO(String orderID, String item, String qty, int price) {
        OrderID = orderID;
        Item = item;
        Qty = qty;
        Price = price;
    }

    public OrderDetailDTO() {

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

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
