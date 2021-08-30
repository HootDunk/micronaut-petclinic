package oci.example.petclinic.fixture;

import io.micronaut.runtime.server.EmbeddedServer;
import oci.example.petclinic.repository.OwnerRepository;
import oci.example.petclinic.repository.SpecialtyRepository;

public interface RepositoryFixture {

    EmbeddedServer getEmbeddedServer();

    default SpecialtyRepository getSpecialtyRepository() {
        return getEmbeddedServer().getApplicationContext().getBean(SpecialtyRepository.class);
    }

    default OwnerRepository getOwnerRepository(){
        return getEmbeddedServer().getApplicationContext().getBean(OwnerRepository.class);
    }



}
