package datatype.dto;

public class UserDto {

    private int id;
    private String email;
    private String name;
    private String lastname;
    private String hashedPassword;
    private String birthDate;
    private int type;


    public UserDto(int id, String email, String name, String lastname, String hashedPassword, String birthDate, int type) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.hashedPassword=hashedPassword;
        this.birthDate = birthDate;
        this.type = type;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

}
