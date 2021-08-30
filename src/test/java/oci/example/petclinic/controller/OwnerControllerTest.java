package oci.example.petclinic.controller;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import oci.example.petclinic.TestContainersSuite;
import oci.example.petclinic.fixture.OwnerFixture;
import oci.example.petclinic.model.Owner;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerControllerTest extends TestContainersSuite implements OwnerFixture {
    @Inject
    @Client("/owner")
    private HttpClient client;

    public static Owner createOwner(String firstName, String lastName){
        Owner owner = new Owner();
        owner.setAddress("somewhere");
        owner.setCity("wildwood");
        owner.setTelephone("1234567890");
        owner.setFirstName(firstName);
        owner.setLastName(lastName);

        return owner;
    }


    @Test
    void testGetAllOwnersOrderByLastName(){
        Owner owner1 = saveAnOwner(createOwner("John", "Apple"));
        Owner owner2 = saveAnOwner(createOwner("Vincente", "Luque"));

        final HttpRequest<Object> request = HttpRequest.
                GET("/");

        final HttpResponse<List<Owner>> response =
                client.toBlocking().exchange(request, Argument.listOf(Owner.class));

        assertEquals(HttpStatus.OK, response.getStatus());

        response.getBody().get().forEach(o -> System.out.println(o.toString()));
        assertEquals(owner1.getId(), response.getBody().get().get(0).getId());
        assertEquals(owner2.getId(), response.getBody().get().get(1).getId());
    }
}
