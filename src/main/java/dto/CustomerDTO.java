package dto;

public class CustomerDTO {
    private String id;
    private String name;
    private String phone;

    public CustomerDTO(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public CustomerDTO() {
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
