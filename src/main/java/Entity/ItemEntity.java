package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class ItemEntity {
    @Id
    private String id;
    private String itemName;
    private String itemQty;
    private int itemPrice;

    public ItemEntity(String id, String itemName, String itemQty, int itemPrice) {
        this.id = id;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
    }

    public ItemEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQty() {
        return itemQty;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}
