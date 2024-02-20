package com.skynet;


import com.skynet.converter.BirthdayConverter;
import com.skynet.entity.Birthday;
import com.skynet.entity.Role;
import com.skynet.entity.User;
import com.skynet.util.HibernateUtil;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;


public class HibernateRunner {
    public static void main(String[] args) {
        User user = User.builder()
                .username("alex1337@gmail.com")
                .lastname("Ali")
                .firstname("Alex")
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session1 = sessionFactory.openSession()) {
                session1.beginTransaction();

                session1.saveOrUpdate(user);

                session1.getTransaction().commit();
            }

            try (Session session2 = sessionFactory.openSession()) {
                session2.beginTransaction();

//                session2.delete(user);
//                refresh/merge
                user.setFirstname("ggg");
                session2.merge(user);

                session2.getTransaction().commit();
            }
        }
    }
}
