package oci.example.petclinic.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import oci.example.petclinic.model.Owner;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    List<Owner> findAllOrderByLastName();
}
