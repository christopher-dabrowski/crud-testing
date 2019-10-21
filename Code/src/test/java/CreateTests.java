import entity.FamilyMember;
import entity.Product;
import entity.Purchase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CreateTests {

	@Test
	public void createFamilyMember() {
		//Given
		String name = "AAA";
		String surname = "AAA";

		//When
		FamilyMember familyMember = CRUD.createFamilyMember(name, surname);
		List<FamilyMember> familyMemberList = CRUD.listFamilyMembers();

		//Then
		boolean onList = false;
		for (FamilyMember f : familyMemberList) {
			if (f.getName().equals(name) && f.getSurname().equals(surname)) {
				onList = true;
				break;
			}
		}
		assertTrue(onList);
	}

	@Test
	public void createProduct() {
		//Given
		String productName = "piwo";

		//When
		Product product = CRUD.createProduct(productName);
		List<Product> productList = CRUD.listProducts();

		//Then
		boolean onList = false;
		for (Product p : productList) {
			if (p.getName().equals(productName)) {
				onList = true;
				break;
			}
		}
		assertTrue(onList);
	}

	@Test
	public void createPurchase() {
		//Given
		String productName = "pomidorówka";
		BigDecimal money = new BigDecimal(3.59);
		int familyMember = 1;
		int amount = 1;
		boolean settled = true;

		//When
		Purchase purchase = CRUD.createPurchase(productName, money, familyMember, amount, settled);
		List<Purchase> purchaseList = CRUD.listPurchases();
		//Then
		boolean found = false;
		for (Purchase purchase1 : purchaseList) {
			if (
					purchase1.getMoney().floatValue() == money.floatValue()
					&& purchase1.getFamily_member() == familyMember
					&& purchase1.getAmount() == amount
					&& purchase1.isSettled() == settled
//			purchase1.equals(purchase)
				) {
				found = true;
				break;
			}
		}
		assertTrue(found);
//		assertTrue(purchaseList.contains(purchase));
	}

	@Test
	public void createNewRecordOnShoppingList() {
	}
}