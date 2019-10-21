import entity.FamilyMember;
import entity.Product;
import entity.Purchase;
import entity.ShoppingList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.fail;

public class DeleteTests {
    @Test
    public void deleteCreatedFamilyMember() {
        //Given
        SessionFactory sessionFactory = CRUD.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int hopefullyFreeId = 5469703;
        FamilyMember familyMemberToDelete = new FamilyMember("Agata", "Wysocka");
        familyMemberToDelete.setId(hopefullyFreeId);
        try {
            transaction = session.beginTransaction();

            session.save(familyMemberToDelete);

            transaction.commit();
        }
        catch (Exception e) {
            if (transaction!=null)
                transaction.rollback();
            throw e;
        }
        finally {
//            transaction.rollback();
            session.close();
        }

        //When
        try {
            CRUD.deleteFamilyMember(hopefullyFreeId);
        } catch (Exception e) {
            fail();
        }

        //Then no exception
    }

    @Test
    public void deleteCreatedProduct() {
        //Given
        SessionFactory sessionFactory = CRUD.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int hopefullyFreeId = 5469703;
        Product toDelete = new Product("Szczotka do zębów");
        toDelete.setId(hopefullyFreeId);
        try {
            transaction = session.beginTransaction();

            session.save(toDelete);

            transaction.commit();
        }
        catch (Exception e) {
            if (transaction!=null)
                transaction.rollback();
            throw e;
        }
        finally {
//            transaction.rollback();
            session.close();
        }

        //When
        try {
            CRUD.deleteProduct(hopefullyFreeId);
        } catch (Exception e) {
            fail();
        }

        //Then no exception
    }
}
