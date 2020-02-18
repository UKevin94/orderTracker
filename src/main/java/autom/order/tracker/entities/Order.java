package autom.order.tracker.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="users_id", nullable=false)
    private User users;

    @Column(name="customer")
    private String customer;

    @Column(name="order_products")
    private String products;

    @Column(name="order_date")
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private Date orderDate;

    @Column(name="order_price")
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
