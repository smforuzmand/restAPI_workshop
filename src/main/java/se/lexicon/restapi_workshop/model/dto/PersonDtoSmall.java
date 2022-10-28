package se.lexicon.restapi_workshop.model.dto;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;


@EqualsAndHashCode
@ToString
public class PersonDtoSmall {
    private Integer personId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;


    public PersonDtoSmall() {

    }

    public PersonDtoSmall(Integer personId, String firstName, String lastName, LocalDate birthDate) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;

    }



    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
