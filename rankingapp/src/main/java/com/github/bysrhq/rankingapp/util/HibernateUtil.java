/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.bysrhq.rankingapp.util;

import com.github.bysrhq.rankingapp.domain.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author bysrhq
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            final MetadataSources metadataSources = new MetadataSources(registry)
                    .addAnnotatedClass(Person.class);
            final Metadata metadata = metadataSources
                    .getMetadataBuilder()
                    .build();
            sessionFactory = metadata.buildSessionFactory();
        }
        
        return sessionFactory;
    }
}
