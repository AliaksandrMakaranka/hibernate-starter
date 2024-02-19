package com.skynet;


import com.skynet.converter.BirthdayConverter;
import com.skynet.entity.Birthday;
import com.skynet.entity.Role;
import com.skynet.entity.User;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
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
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.registerTypeOverride(new JsonBinaryType());
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

//             User user = User.builder()
//                     .username("alex@gmail.com")
//                     .firstname("Alexx")
//                     .lastname("Ali")
//                     .info("""
//                             {
//                                 "name": "Alex",
//                                 "id": "25"
//                             }
//                             """)
//                     .birthDate(new Birthday(LocalDate.of(1999, 12, 31)))
//                     .role(Role.ADMIN)
//                    .build();
//
//            session.save(user);
//            session.saveOrUpdate(user);
            session.get(User.class, "alex@gmail.com");
//            session.persist(user);
            session.getTransaction().commit();
        }
    }
}
