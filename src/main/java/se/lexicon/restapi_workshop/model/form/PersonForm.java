package se.lexicon.restapi_workshop.model.form;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDate;



@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PersonForm {



    private String firstName;


    private String lastName;

    private LocalDate birthDate;
}
