package oci.example.petclinic.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import oci.example.petclinic.model.Vet;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface VetRepository extends CrudRepository<Vet, Integer> {
}
