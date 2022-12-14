package se.lexicon.restapi_workshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemDto {

    private Integer todoId;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private PersonDtoSmall assignee;









}
