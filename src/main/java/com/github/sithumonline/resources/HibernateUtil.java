package com.github.sithumonline.resources;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure(
                    HibernateUtil.class.getClassLoader().getResource("schema.xmls")
            ).buildSessionFactory();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
