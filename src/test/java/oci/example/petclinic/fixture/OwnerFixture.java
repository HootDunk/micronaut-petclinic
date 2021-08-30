package oci.example.petclinic.fixture;

import oci.example.petclinic.model.Owner;

public interface OwnerFixture extends RepositoryFixture {
    default Owner saveAnOwner(Owner owner) {
        return getOwnerRepository().save(owner);
    }

}
