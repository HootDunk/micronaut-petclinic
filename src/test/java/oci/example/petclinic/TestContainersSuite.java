package oci.example.petclinic;

import io.micronaut.context.env.Environment;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import oci.example.petclinic.fixture.RepositoryFixture;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@MicronautTest(environments = {Environment.TEST}, transactional = false)
@Testcontainers
public abstract class TestContainersSuite implements RepositoryFixture, TestPropertyProvider {
    @Container
    private static final PostgreSQLContainer<?> postgres;

    static {
        postgres = new PostgreSQLContainer<>("postgres:latest");
        postgres.waitingFor(Wait.forLogMessage(".*database system is ready to accept connections\\n", 1));
        postgres.start();
    }

    @Inject
    private EmbeddedServer embeddedServer;

    @Inject
    private Flyway flyway;

    private final boolean shouldResetDBAfterEachTest;

    public TestContainersSuite() {
        this(true);
    }

    public TestContainersSuite(boolean shouldResetDBAfterEachTest) {
        this.shouldResetDBAfterEachTest = shouldResetDBAfterEachTest;
    }

    @BeforeEach
    private void setup() {
        flyway.migrate();
    }

    @AfterEach
    private void teardown() {
        if(shouldResetDBAfterEachTest) {
            flyway.clean();
        }
    }

    @Override
    public Map<String, String> getProperties() {
        HashMap<String, String> properties = new HashMap<>();
        properties.put("datasources.default.url", getJdbcUrl());
        properties.put("datasources.default.username", getUsername());
        properties.put("datasources.default.password", getPassword());
        properties.put("datasources.default.dialect", "POSTGRES");
        properties.put("datasources.default.driverClassName", "org.testcontainers.jdbc.ContainerDatabaseDriver");
        return properties;
    }

    static String getJdbcUrl() {
        return postgres.getJdbcUrl();
    }

    static String getUsername() {
        return postgres.getUsername();
    }

    static String getPassword() {
        return postgres.getPassword();
    }

    @Override
    public EmbeddedServer getEmbeddedServer() {
        return embeddedServer;
    }
}
