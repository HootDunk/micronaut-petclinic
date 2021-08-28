package oci.example.petclinic.model;

import oci.example.petclinic.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    @NotEmpty
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
    protected String firstName;

    @Column(name = "last_name")
    @NotEmpty
    @Pattern(regexp = "[a-z-A-Z]*", message = "Last name has invalid characters")
    protected String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
