package com.example.persist;

import com.example.persist.entity.User;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;

/**
 * Created by ycwu on 2017/9/21.
 */
public class TestPersist {

    @Test
    public void test() {
        // persistence-unit name in persistence.xml
        Injector injector = Guice.createInjector(new JpaPersistModule("jpa"));
        PersistInitializer persistInitializer = injector.getInstance(PersistInitializer.class);

        EntityManager entityManager = injector.getInstance(EntityManager.class);

        User u1 = new User();
        u1.setName("aaa");
        u1.setAge(11);
        entityManager.persist(u1);

        //User u2 = (User) entityManager.createQuery("select u from com.example.persist.entity.User u  where u.age=11").getResultList().get(0);
        Assert.assertTrue(u1.getId() == entityManager.find(User.class, 1).getId());
    }
}
