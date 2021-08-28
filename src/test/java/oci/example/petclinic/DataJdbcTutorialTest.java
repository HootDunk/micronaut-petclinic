package oci.example.petclinic;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
class DataJdbcTutorialTest extends TestContainersSuite {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testTheTestContainer(){
        getProperties();

        System.out.println(getEmbeddedServer().getURL());
        System.out.println(getEmbeddedServer().getEnvironment().getActiveNames());
    }

}
