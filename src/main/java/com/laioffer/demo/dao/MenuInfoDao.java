package com.laioffer.demo.dao;

import com.laioffer.demo.entity.MenuItem;
import com.laioffer.demo.entity.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuInfoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurant> getRestaurants(){
        // session对象没有直接全表搜索的方法
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            // 增加查找参数，对restaurant表进行查找
            CriteriaQuery<Restaurant> criteriaQuery = builder.createQuery(Restaurant.class);
            criteriaQuery.from(Restaurant.class);
            // 返回restaurant表中所有的row
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId){
        try (Session session = sessionFactory.openSession()) {
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) {
                return restaurant.getMenuItemList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();

    }

    public MenuItem getMenuItem(int menuItemId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(MenuItem.class, menuItemId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
