package hw;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("JPATest");
        em = emf.createEntityManager();


    }

    public static void addDish(DishSample ds) {
        em.getTransaction().begin();
        try {
            em.persist(ds);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

    }

    public static List<DishSample> getByCost(int cost) {
        DishSample ds = null;
        List<DishSample> dSList = new ArrayList<>();
        try {
            Query query = em.createQuery(
                    "SELECT ds FROM DishSample ds where ds.price <= :cost", DishSample.class);
            query.setParameter("cost", cost);
            dSList = (List<DishSample>) query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dSList;
    }
    public static List<DishSample> getByDiscount(boolean disc) {
        DishSample ds = null;
        List<DishSample> dSList = new ArrayList<>();
        try {
            Query query = em.createQuery(
                    "SELECT ds FROM DishSample ds where ds.hasDiscount = :disc", DishSample.class);
            query.setParameter("disc", disc);
            dSList = (List<DishSample>) query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dSList;
    }
}

