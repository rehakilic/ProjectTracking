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
        birimObjectModel.setBirimAdi("test4");
        birimObjectModel.setUstBirimId(2);
        birimObjectModel.setCreatedDate(new Date());

        MobileNumbersModel mobileNumbersModel = new MobileNumbersModel();
        mobileNumbersModel.setMobile_no(12412513);

        birimObjectModel.setMobileNumbersModel(mobileNumbersModel);
        //mobileNumbersModel.setBirimObjectModel(birimObjectModel);

        session.save(birimObjectModel);
        //session.save(mobileNumbersModel);

        tx.commit();
        session.close();
        //sessionFactory.close();
    }
}
