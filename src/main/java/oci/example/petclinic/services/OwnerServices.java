package oci.example.petclinic.services;

import oci.example.petclinic.model.Owner;

import java.util.List;

public interface OwnerServices {
    List<Owner> findAllOrderByLastName();
}
