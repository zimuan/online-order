package com.laioffer.demo.service;

import com.laioffer.demo.dao.CustomerDao;
import com.laioffer.demo.entity.Cart;
import com.laioffer.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;



    public void signUp(Customer customer) {
        // 分配购物车给customer
        Cart cart = new Cart();
        customer.setCart(cart);

        customer.setEnabled(true);
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}

