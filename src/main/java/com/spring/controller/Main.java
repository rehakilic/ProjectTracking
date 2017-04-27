package com.spring.controller;

import com.spring.hibernate.BirimObjectModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main (String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        BirimObjectModel birimObjectModel = new BirimObjectModel();
        birimObjectModel.setBirimAdi("test");
        birimObjectModel.setBirimId(1);
        birimObjectModel.setUstBirimId(5);
        session.save(birimObjectModel);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
