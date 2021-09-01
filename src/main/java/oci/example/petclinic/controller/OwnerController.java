package oci.example.petclinic.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import oci.example.petclinic.model.Owner;
import oci.example.petclinic.services.OwnerServices;

import java.util.List;

@Controller("api/owners")
public class OwnerController {

    private final OwnerServices ownerServices;

    public OwnerController(OwnerServices ownerServices) {
        this.ownerServices = ownerServices;
    }

    @Get
    public HttpResponse<List<Owner>> findAllOrderByLastName() {
        return HttpResponse.ok(ownerServices.findAllOrderByLastName());
    }

    @Post
    public HttpResponse<Owner> addOwner(Owner owner){
        return HttpResponse.created(ownerServices.save(owner));
    }
}
