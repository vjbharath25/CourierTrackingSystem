package com.courier.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {

        SessionFactory factory = null;

        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();

            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Customer customer = new Customer(
                    "Vijay",
                    "vijay@gmail.com",
                    "9876543210",
                    "chennai"
            );

            session.save(customer);

            transaction.commit();

            System.out.println("Customer saved successfully!");

            session.close();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}