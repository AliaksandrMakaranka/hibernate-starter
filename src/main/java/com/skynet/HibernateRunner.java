package com.skynet;


import com.skynet.entity.Birthday;
import com.skynet.entity.Company;
import com.skynet.entity.PersonalInfo;
import com.skynet.entity.User;
import com.skynet.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

@Slf4j
public class HibernateRunner {
    public static void main(String[] args) {
        Company company = Company.builder()
                .name("Skynet")
                .build();

        User user = User.builder()
                .username("iGar@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .lastname("Ali")
                        .firstname("Alex")
                        .birthDate(new Birthday(LocalDate.of(2000, 1, 1)))
                        .build())
                .company(company)
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();


                session1.save(user);
//                User user1 = session1.get(User.class, 1L);
//                session1.evict(user1);

                session1.getTransaction().commit();
            }
        }
    }
}
