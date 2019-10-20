import entity.FamilyMember;
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
}
