package hibernate;

import hibernate.entity.shoes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(shoes.class)
                .buildSessionFactory();
    }
    public void close() {
        factory.close();
    }


    public static void main(String[] args) {
        HibernateApp demo = new HibernateApp();

        try {
            //demo.createShoe();
            //demo.readShoe();
            //demo.deleteShoe();
            //demo.updateShoe();


        } finally {
            demo.close();
        }
    }
    /**Only one table created so no mapping relationships are used**/


    private void createShoe() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        /** CREATE **/
        shoes newShoe = new shoes("555088-001","BLACK/VARSITY RED-WHITE",160.00, DateUtils.parseDate("09/03/2016") ,"Jordan 1 Bred Desc");
        System.out.println(newShoe);

        session.save(newShoe);
        session.getTransaction().commit();
    }

    private void deleteShoe(int shoeId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        /** DELETE **/
        shoes sShoes = session.get(shoes.class, shoeId);
        if (sShoes != null) {
            session.delete(sShoes);
        }
        session.getTransaction().commit();
    }


    private void readShoe(int shoeId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        /** READ **/
        shoes sShoes = session.get(shoes.class, shoeId);
        System.out.println(sShoes);
        session.getTransaction().commit();
    }

    private void updateShoe(int shoeId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** UPDATE**/
        shoes sShoes = session.get(shoes.class, shoeId);
        if (sShoes!= null){
            sShoes.setDescription("jordantext");
            sShoes.setDescription(sShoes.getDescription().toUpperCase());
        }

        System.out.println(sShoes);

        session.getTransaction().commit();
    }


}
