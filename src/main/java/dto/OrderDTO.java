package dto;


public class OrderDTO {

    private String id;
    private String Customer;
    private String Item;
    private int Total;

    public OrderDTO(String id, String customer, String item, int total) {
        this.id = id;
        Customer = customer;
        Item = item;
        Total = total;
    }

    public OrderDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
