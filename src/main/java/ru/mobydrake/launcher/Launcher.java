package ru.mobydrake.launcher;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.mobydrake.entites.Person;
import ru.mobydrake.entites.Product;

import java.net.URL;
import java.security.ProtectionDomain;

public class Launcher {
    public static void main(String[] args) throws Exception {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
        // CRUD
        Session session = null;

        // CREATE
        try {
            session = factory.getCurrentSession();
            Person person = new Person();
            person.setName("Bob");
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } finally {
//            factory.close();
//            session.close();
        }

        // CREATE
        try {
            session = factory.getCurrentSession();
            Product product = new Product();
            product.setTitle("Pen");
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } finally {
//            factory.close();
//            session.close();
        }

        session = factory.getCurrentSession();
        session.beginTransaction();
        Product pen = session.get(Product.class, 1);
        System.out.println(pen);
        session.getTransaction().commit();

//        Server server = new Server(8080);
//        ProtectionDomain domain = Launcher.class.getProtectionDomain();
//        URL location = domain.getCodeSource().getLocation();
//        WebAppContext webapp = new WebAppContext();
//        webapp.setContextPath("/");
//        webapp.setWar(location.toExternalForm());
//        server.setHandler(webapp);
//        server.start();
//        server.join();


    }
}
