import entity.FamilyMember;
import entity.Product;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReadTests {
    @Test
    public void FindFamilyMemberInDatabase() {
        //Given
        String knownName = "Jan";
        String knownSurname = "Dudek";

        //When
        List<FamilyMember> result = CRUD.listFamilyMembers();

        //Then
        boolean notInTheList = true;
        for(FamilyMember familyMember : result) {
            if (familyMember.getName().equals(knownName)
                && familyMember.getSurname().equals(knownSurname)) {
                notInTheList = false;
                break;
            }
        }

        assertFalse(notInTheList);
    }

    @Test
    void findKnownProductInDatabase() {
        //Given
        String productName = "szynka";

        //When
        List<Product> result = CRUD.listProducts();

        //Then
        boolean notInTheList = true;
        for(Product product : result) {
            if (product.getName().equals(productName)) {
                notInTheList = false;
                break;
            }
        }

        assertFalse(notInTheList);
    }
}
