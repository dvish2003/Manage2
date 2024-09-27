package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerEntity {
    @Id
   private String id;

   private String name;
   private String phone;

    public CustomerEntity(String id, String name, String phone) {
        this.id = String.valueOf(id);
        this.name = name;
        this.phone = phone;
    }

    public CustomerEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
