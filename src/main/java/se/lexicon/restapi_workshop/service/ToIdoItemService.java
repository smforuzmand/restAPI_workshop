package se.lexicon.restapi_workshop.service;

import se.lexicon.restapi_workshop.model.dto.TodoItemDto;
import se.lexicon.restapi_workshop.model.form.TodoItemForm;

import java.time.LocalDate;
import java.util.List;

public interface ToIdoItemService {


    TodoItemDto create(TodoItemForm itemForm);
    TodoItemDto findById(Integer todoItemId);
    List<TodoItemDto> findAll();
    List<TodoItemDto> findAllUnassigned();
    List<TodoItemDto> findAllByPersonId(Integer personId);
    List<TodoItemDto> findByDoneStatus(Boolean doneStatus);
    List<TodoItemDto> findByDeadlineBetween(LocalDate start, LocalDate end);
    List<TodoItemDto> findByDeadlineBefore(LocalDate localDate);
    List<TodoItemDto> findByDeadlineAfter(LocalDate localDate);
    List<TodoItemDto> findByTitle(String title);
    List<TodoItemDto> findAllUnfinishedAndOverdue();
    TodoItemDto update(Integer id, TodoItemForm form);
    boolean delete(Integer id);

}
