package datatype.dto;

public class GymDto {

    private int id;
    private String email;
    private String name;
    private String lastname;


    public GymDto(int id, String name, String address) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastname = lastname;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
