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

    @Test
    public void deleteCreatedShoppingListItem() {
        //Given
        SessionFactory sessionFactory = CRUD.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        int hopefullyFreeIdProduct = 5469703;
//        int hopefullyFreeIdShoppingItem = hopefullyFreeIdProduct + 1;

        Product tmpProduct = new Product("Szczotka do zębów");
        tmpProduct.setId(hopefullyFreeIdProduct);

        ShoppingList toDelete = new ShoppingList(hopefullyFreeIdProduct, 3);
        toDelete.setProduct_id(hopefullyFreeIdProduct);

        try {
            transaction = session.beginTransaction();

            session.save(tmpProduct);
            session.save(toDelete);

            transaction.commit();
        }
        catch (Exception e) {
            if (transaction!=null)
                transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        //When
        try {
            CRUD.deleteShoppingListItem(hopefullyFreeIdProduct);
        } catch (Exception e) { //Then no exception
            fail();
        } finally { //Cleanup
            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                session.delete(tmpProduct);

                transaction.commit();
            }
            catch (Exception e) {
                if (transaction!=null)
                    transaction.rollback();
                throw e;
            }
            finally {
                session.close();
            }
        }

    }
}
