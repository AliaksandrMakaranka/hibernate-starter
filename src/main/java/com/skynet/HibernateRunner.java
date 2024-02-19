package com.skynet;


import com.skynet.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;


public class HibernateRunner {
    public static void main(String[] args) {
//        BlockingDeque<Connection> poll = null;
//         Connection connection = poll.take();
//        SessionFactory

//        Connection connection = DriverManager
//                .getConnection("db.url", "db.username", "db.password");

        Configuration configuration = new Configuration();
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
//        configuration.addAnnotatedClass(User.class);
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

             User user = User.builder()
                     .username("alex@gmail.com")
                     .firstname("Alex")
                     .lastname("Ali")
                     .birthDate(LocalDate.of(1999, 12, 31))
                     .age(18)
                    .build();

            session.save(user);
//            session.persist(user);
            session.getTransaction().commit();
        }
    }
}
