package se.lexicon.restapi_workshop.model.dto;

import lombok.*;

import java.time.LocalDate;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TodoItemDtoSmall {

    private Integer todoId;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;


}
