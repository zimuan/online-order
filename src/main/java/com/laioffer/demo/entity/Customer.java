package com.laioffer.demo.entity;

// POJO 没有逻辑功能 很简单
// eg. Customer Menu Order Restaurant
// 方便代码的解耦合，每个package应该有自己独立的功能
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable  {

    private static final long serialVersionUID = 2652327633296064143L;

    @Id
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



}
