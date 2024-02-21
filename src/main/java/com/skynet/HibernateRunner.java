package com.skynet;


import com.skynet.entity.PersonalInfo;
import com.skynet.entity.User;
import com.skynet.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Slf4j
public class HibernateRunner {
    public static void main(String[] args) {
        User user = User.builder()
                .username("alex1337@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .lastname("Ali")
                        .firstname("Alex")
                        .build())
                .build();

        log.info("User entity is in transient state, object: {}", user);

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();
                log.trace("Transaction is created, {}", transaction);

                session1.saveOrUpdate(user);
                log.trace("User is in persistent state; {}, session {}", user, session1);

                session1.getTransaction().commit();
            }
            log.warn("User is in detached state; {}, session is closed {}", user, session1);
        } catch (Exception exception) {
            log.error("Exception occurred", exception);
            throw exception;
        }
    }
}
