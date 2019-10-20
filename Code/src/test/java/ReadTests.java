import entity.FamilyMember;
import entity.Product;
import entity.Purchase;
import entity.ShoppingList;
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
    public void findKnownProductInDatabase() {
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

    @Test
    public void findKnownPurchaseInDatabase() {
        //Given
        int knowProductID = 2;
        float knownPrice = 2.85f;
        int knownFamilyMemberID = 1;
        int knownAmount = 2;

        //When
        List<Purchase> purchases = CRUD.listPurchases();

        //Then
        boolean notInTheList = true;
        for(Purchase purchase : purchases) {
            if (purchase.getId() == knowProductID
                && purchase.getMoney() == knownPrice
                && purchase.getFamily_member() == knownFamilyMemberID
                && purchase.getAmount() == knownAmount) {
                notInTheList = false;
                break;
            }
        }

        assertFalse(notInTheList);
    }

    @Test
    public void findKnownShoppingListItem() {
        //Given
        int knownProducID = 6;
        int knownAmount = 2;

        //When
        List<ShoppingList> items = CRUD.listShpppingListItems();

        //Then
        boolean notInTheList = true;
        for(ShoppingList item : items) {
            if (item.getProduct_id() == knownProducID
                && item.getAmount() == knownAmount) {
                notInTheList = false;
                break;
            }
        }

        assertFalse(notInTheList);
    }
}
