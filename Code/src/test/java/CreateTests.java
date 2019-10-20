import entity.FamilyMember;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CreateTests {

	@Test
	public void createFamilyMember() {
		//Given
		String name = "Andrzej";
		String surname = "Andrzejewicz";

		//When
		FamilyMember familyMember = CRUD.createFamilyMember(name, surname);
		List<FamilyMember> familyMemberList = CRUD.listFamilyMembers();

		//Then
		boolean onList = false;
		for (FamilyMember f : familyMemberList) {
			if (familyMember.getName().equals(name) && familyMember.getSurname().equals(surname)) {
				onList = true;
				break;
			}
		}
		assertTrue(onList);
	}

	@Test
	public void createProduct() {
	}

	@Test
	public void createPurchase() {
	}

	@Test
	public void createNewRecordOnShoppingList() {
	}
}