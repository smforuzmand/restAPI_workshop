package se.lexicon.restapi_workshop.service;


import org.springframework.stereotype.Service;
import se.lexicon.restapi_workshop.model.dto.PersonDto;
import se.lexicon.restapi_workshop.model.dto.PersonDtoSmall;
import se.lexicon.restapi_workshop.model.dto.TodoItemDto;
import se.lexicon.restapi_workshop.model.dto.TodoItemDtoSmall;
import se.lexicon.restapi_workshop.model.entity.Person;
import se.lexicon.restapi_workshop.model.entity.TodoItem;
import se.lexicon.restapi_workshop.model.form.PersonForm;
import se.lexicon.restapi_workshop.model.form.TodoItemForm;

import java.util.ArrayList;
import java.util.List;

//create a service class aims to convert objects in meaningfully ways
@Service
public class ServiceConverting {

//create methods for converting Forms to the entities


    public Person toPerson(PersonForm formDto) {
    return  new Person(0, formDto.getFirstName(), formDto.getLastName(), formDto.getBirthDate(), new ArrayList<>());

    }

    public TodoItem toTodoItem(TodoItemForm itemForm) {
       return new TodoItem(0,itemForm.getTitle(),itemForm.getDescription(),itemForm.getDeadLine(),itemForm.isDone(),null);
    }

    public TodoItemDto todoItemDto(TodoItem todoItem) {
        PersonDtoSmall personDtoSmall = null;

        if (todoItem.getAssignee() != null) {
            Person person = todoItem.getAssignee();
            personDtoSmall = new PersonDtoSmall(person.getPersonId(), person.getFirstName(), person.getLastName(), person.getBirthDate());

        }

        return new TodoItemDto(todoItem.getTodoId(), todoItem.getTitle(), todoItem.getDescription(), todoItem.getDeadLine(), todoItem.isDone(), personDtoSmall);
    }


    public PersonDto toPersonDto(Person person) {


        List<TodoItemDtoSmall> todoItemDtoSmallList = new ArrayList<>();

        for (TodoItem item : person.getTodoItems()) {
            todoItemDtoSmallList.add(new TodoItemDtoSmall(item.getTodoId(), item.getTitle(), item.getDescription()
                    , item.getDeadLine(), item.isDone()));
        }

        return new PersonDto(person.getPersonId(), person.getFirstName(), person.getLastName(), person.getBirthDate(), todoItemDtoSmallList);
    }


}
