package se.lexicon.restapi_workshop.model.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.REFRESH;


@EqualsAndHashCode(exclude = {"assignee"})
@ToString(exclude = "asignee")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "todo_Id")
    private Integer todoId;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDate deadLine;
    private boolean done;


    @ManyToOne(

            cascade = {DETACH, REFRESH},
            fetch = FetchType.LAZY
    )

    @JoinColumn(name = "assignee_id")
    private Person assignee;


}
