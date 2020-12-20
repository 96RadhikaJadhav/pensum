package swiss.fihlon.pensum.backend.entity;

import javax.persistence.Entity;
import swiss.fihlon.pensum.backend.AbstractEntity;

@Entity
public class User extends AbstractEntity {

    private String email;
    private String password;

    public User() {
    }

    public User(final String email, final String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

}
