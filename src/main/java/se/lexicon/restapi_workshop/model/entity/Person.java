package se.lexicon.restapi_workshop.model.entity;

import lombok.*;
import org.modelmapper.internal.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;


@EqualsAndHashCode
@ToString(exclude = "todoItems")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;

@Column(nullable = false , name = "first_name")
    private String firstName;

@Column(nullable = false, name = "last_name")
    private String lastName;

    private LocalDateTime birthDate;



    @OneToMany(
            cascade = {CascadeType.DETACH,REFRESH,MERGE},
            fetch = FetchType.LAZY,
            mappedBy = "assignee"
    )
    private List<TodoItem> todoItems;


    public void setTodoItems(List<TodoItem> todoItems) {
        if (todoItems==null) todoItems = new ArrayList<>();
        if (todoItems.isEmpty()) {
            if (this.todoItems != null) {
                for (TodoItem todoItem : this.todoItems) {
                    todoItem.setAssignee(null);
                }
            }
        }else{
            for (TodoItem todoItem : todoItems) {
                todoItem.setAssignee(this);
            }
        }
        this.todoItems = todoItems;

    }

    public List<TodoItem> getTodoItems() {
        if (todoItems==null) todoItems = new ArrayList<>();
        return todoItems;
    }

    public void addTodoItem(TodoItem... todoItems) {
        if (todoItems==null|| todoItems.length==0) return;
        if (this.todoItems==null) this.todoItems = new ArrayList<>();
        for (TodoItem todoItem : todoItems) {
            if (!this.todoItems.contains(todoItem)) {
                this.todoItems.add(todoItem);
                todoItem.setAssignee(this);
            }
        }
    }

    public void removeTodoItem(TodoItem... todoItems) {
        if (todoItems==null||todoItems.length==0)return;
        if (this.todoItems==null) this.todoItems = new ArrayList<>();
        for (TodoItem todoItem : todoItems) {
            if (this.todoItems.remove(todoItem)) {
                todoItem.setAssignee(null);
            }
        }
    }


















}
