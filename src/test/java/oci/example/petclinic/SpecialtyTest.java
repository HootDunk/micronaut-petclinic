package oci.example.petclinic;

import oci.example.petclinic.fixture.SpecialtyFixture;
import oci.example.petclinic.model.Specialty;
import org.junit.jupiter.api.Test;


public class SpecialtyTest extends TestContainersSuite implements SpecialtyFixture {

    @Test
    void testSavingASpecialty(){
        Specialty specialty = new Specialty();
        specialty.setName("Fix doggos");
        Specialty savedSpecialty = saveASpecialty(specialty);
        System.out.println(savedSpecialty.toString());
        System.out.println(savedSpecialty.getId());
    }
}
