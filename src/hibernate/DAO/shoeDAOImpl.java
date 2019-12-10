package hibernate.DAO;

import hibernate.DateUtils;
import hibernate.entity.shoes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class shoeDAOImpl implements shoeDAO{
    @Autowired
    private SessionFactory factory;

    @Override
    public List<shoes> getShoes() {
        Session session = factory.getCurrentSession();

        List<shoes> list = session.createQuery("from shoes", shoes.class).getResultList();

        return list;
    }

    public void createShoe() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        /** CREATE **/
        shoes newShoe = new shoes("555088-001","BLACK/VARSITY RED-WHITE",160.00, DateUtils.parseDate("09/03/2016") ,"Jordan 1 Bred Desc");
        System.out.println(newShoe);

        session.save(newShoe);
        //session.getTransaction().commit();
    }

    @Override
    public void saveShoe(shoes aShoe) {

        Session session = factory.getCurrentSession();

        session.saveOrUpdate(aShoe);
    }

    public void deleteShoe(int shoeId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        /** DELETE **/
        shoes sShoes = session.get(shoes.class, shoeId);
        if (sShoes != null) {
            session.delete(sShoes);
        }
        //session.getTransaction().commit();
    }


    public void readShoe(int shoeId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        /** READ **/
        shoes sShoes = session.get(shoes.class, shoeId);
        System.out.println(sShoes);
        //session.getTransaction().commit();
    }

    public void updateShoe(int shoeId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** UPDATE**/
        shoes sShoes = session.get(shoes.class, shoeId);
        if (sShoes!= null){
            sShoes.setDescription("jordantext");
            sShoes.setDescription(sShoes.getDescription().toUpperCase());
        }

        System.out.println(sShoes);

        //session.getTransaction().commit();
    }

    @Override
    public List<shoes> getShoesByName(String searchTerm) {

        Session session = factory.getCurrentSession();

        Query<shoes> query = session.createQuery("from shoes s where lower(s.name) like :searchTerm");

        searchTerm = "%" + searchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", searchTerm);

        return query.getResultList();


    }



}
