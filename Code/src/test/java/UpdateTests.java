import entity.FamilyMember;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UpdateTests {
    @Test
    public void updateNewFamilyMemberName() {
        //Given
        String newName = "Andrzej";

        SessionFactory sessionFactory = CRUD.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int hopefullyFreeId = 5469703;
        FamilyMember familyMemberToUpdate = new FamilyMember("Agata", "Wysocka");
        familyMemberToUpdate.setId(hopefullyFreeId);
        try {
            transaction = session.beginTransaction();
            session.save(familyMemberToUpdate);
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
            CRUD.updateFamilyMember(hopefullyFreeId, newName, familyMemberToUpdate.getSurname());
        } catch (Exception e) {
            fail();
        }

        //Then
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();

            FamilyMember actual = session.get(FamilyMember.class, hopefullyFreeId);
            assertEquals(newName, actual.getName());

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

        //Cleanup
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();

            FamilyMember toDelete = session.get(FamilyMember.class, hopefullyFreeId);
            session.delete(toDelete);

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
