package autom.order.tracker.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="mail")
    private String mail;

    @Column(name="admin")
    private boolean admin;

/*    @OneToMany(mappedBy="users")
    private Set<Order> orders;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

/*    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }*/
}
