package swiss.fihlon.pensum.backend.entity;

import javax.persistence.Entity;
import swiss.fihlon.pensum.backend.AbstractEntity;

@Entity
public class User extends AbstractEntity {

    private String email;
    private String password;
    private Role role;

    public User() {
    }

    public User(final String email, final String password, final Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }
}
