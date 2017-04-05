/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.bysrhq.rankingapp.service;

import com.github.bysrhq.rankingapp.domain.Person;
import com.github.bysrhq.rankingapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bysrhq
 */
public class PersonServiceTest {
    
    private SessionFactory sessionFactory;
    
    @Before
    public void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    @Test
    public void persistPersonTest() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        Person person = new Person();
        person.setName("Pipit Pitriani");
        
        session.save(person);
        
        tx.commit();
        
        session.close();
        
        System.out.println(person);
    }
    
}
