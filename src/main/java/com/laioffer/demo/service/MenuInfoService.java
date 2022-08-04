package com.laioffer.demo.service;

import com.laioffer.demo.dao.MenuInfoDao;
import com.laioffer.demo.entity.MenuItem;
import com.laioffer.demo.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {
    @Autowired
    private MenuInfoDao menuInfoDao;

    public List<Restaurant> getRestaurants(){
        return menuInfoDao.getRestaurants();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId) {
        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    public MenuItem getMenuItem(int id){
        return menuInfoDao.getMenuItem(id);
    }
}
