import entity.FamilyMember;
import entity.Product;
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CRUD {

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        return meta.getSessionFactoryBuilder().build();
    }

    public static void main(String[] args) {
        readTest();
    }

    private static void readTest() {
        Session session = buildSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria = criteriaBuilder.createQuery(Product.class);
            criteria.from(Product.class);

            List<Product> products = session.createQuery(criteria).getResultList();
            session.close();

            for(Product product : products) {
                System.out.println(product.getName());
            }

//            Criteria criteria = session.createCriteria(FamilyMember.class);
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }
}
