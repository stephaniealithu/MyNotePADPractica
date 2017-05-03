package granados.mynotepad.models;

/**
 * Created by Steph on 3/05/2017.
 */

public class User {

    private Integer id;
    private String email;
    private String password;
    private String fullname;

    public User() {
    }

    public User(Integer id, String email, String password, String fullname) {
        this.id = id;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
