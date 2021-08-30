package oci.example.petclinic.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import oci.example.petclinic.model.Owner;
import oci.example.petclinic.services.OwnerServices;

import java.util.List;

@Controller("/owner")
public class OwnerController {

    private final OwnerServices ownerServices;

    public OwnerController(OwnerServices ownerServices) {
        this.ownerServices = ownerServices;
    }

    @Get
    public HttpResponse<List<Owner>> findAllOrderByLastName() {
        return HttpResponse.ok(ownerServices.findAllOrderByLastName());
    }
}
