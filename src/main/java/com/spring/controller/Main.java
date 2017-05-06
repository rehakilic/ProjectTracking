package com.spring.controller;

import com.spring.hibernate.BirimObjectModel;
import com.spring.hibernate.MobileNumbersModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {

    public static void main (String[] args){
        final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        final Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        BirimObjectModel birimObjectModel = new BirimObjectModel();
        birimObjectModel.setBirimAdi("test1");
        //birimObjectModel.setBirimId(1);
        birimObjectModel.setUstBirimId(5);
        birimObjectModel.setCreatedDate(new Date());
        session.save(birimObjectModel);

        BirimObjectModel birimObjectModel2 = new BirimObjectModel();
        birimObjectModel2.setBirimAdi("test4");
        birimObjectModel2.setUstBirimId(2);
        birimObjectModel2.setCreatedDate(new Date());

        MobileNumbersModel mobileNumbersModel = new MobileNumbersModel();
        mobileNumbersModel.setMobile_no(12412513);
        mobileNumbersModel.setBirimObjectModel(birimObjectModel2);

        session.save(mobileNumbersModel);

        tx.commit();
        session.close();
        //sessionFactory.close();
    }
}
