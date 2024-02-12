package com.skynet;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {
//        BlockingDeque<Connection> poll = null;
//         Connection connection = poll.take();
//        SessionFactory

//        Connection connection = DriverManager
//                .getConnection("db.url", "db.username", "db.password");

        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("OK");
        }
    }
}
