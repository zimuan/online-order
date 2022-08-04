package com.laioffer.demo.dao;

import com.laioffer.demo.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(OrderItem orderItem){
        // 数据怎么改不是数据层要管的事，business logic tier does the job
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(orderItem);
            session.getTransaction().commit();
        } catch (Exception exception){
            exception.printStackTrace();
            if (session != null) session.getTransaction().rollback();;
        } finally {
            if (session != null) session.close();
        }
    }
}
