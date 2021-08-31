package oci.example.petclinic.services;

import oci.example.petclinic.model.Owner;
import oci.example.petclinic.repository.OwnerRepository;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class OwnerServicesImpl implements OwnerServices {

    private final OwnerRepository ownerRepo;

    public OwnerServicesImpl(OwnerRepository ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public List<Owner> findAllOrderByLastName() {
        return ownerRepo.findAllOrderByLastName();
    }

    public Owner save(Owner owner) { return ownerRepo.save(owner); }

}
