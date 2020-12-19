package swiss.fihlon.pensum.backend.entity;

import javax.persistence.Entity;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import swiss.fihlon.pensum.backend.AbstractEntity;

@Entity
public class User extends AbstractEntity {

    private String email;
    private String passwordSalt;
    private String passwordHash;
    private Role role;

    public User() {
    }

    public User(final String email, final String password, final Role role) {
        this.email = email;
        this.role = role;
        this.passwordSalt = RandomStringUtils.random(32);
        this.passwordHash = DigestUtils.sha1Hex(password + passwordSalt);
    }

    public boolean checkPassword(final String password) {
        return StringUtils.isNotEmpty(password)
                && DigestUtils.sha1Hex(password + passwordSalt).equals(passwordHash);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(final String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }
}
