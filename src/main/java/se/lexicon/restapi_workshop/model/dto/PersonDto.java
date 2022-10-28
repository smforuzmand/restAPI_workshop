package se.lexicon.restapi_workshop.model.dto;

import lombok.*;
import se.lexicon.restapi_workshop.model.entity.TodoItem;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PersonDto {

    private Integer personId;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;


    private List<TodoItemDtoSmall> todoItems;










}
