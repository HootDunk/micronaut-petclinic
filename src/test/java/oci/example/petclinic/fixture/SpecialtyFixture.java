package oci.example.petclinic.fixture;

import oci.example.petclinic.model.Specialty;

import java.util.Optional;

public interface SpecialtyFixture extends RepositoryFixture {

    default Optional<Specialty> getASpecialty(Integer id){
        return getSpecialtyRepository().findById(id);
    }

    default Specialty saveASpecialty(Specialty specialty){
        return getSpecialtyRepository().save(specialty);
    }
}
