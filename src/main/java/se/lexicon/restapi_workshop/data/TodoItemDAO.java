package se.lexicon.restapi_workshop.data;

import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.restapi_workshop.model.entity.TodoItem;

import java.time.LocalDate;
import java.util.List;

public interface TodoItemDAO extends JpaRepository<TodoItem, Integer> {


    @Query("SELECT t FROM TodoItem t WHERE UPPER(t.title) LIKE UPPER(concat('%',:string,'%') ) ")
    List<TodoItem> findByTitleContains(@Param("string") String string);


    @Query("SELECT t FROM TodoItem t WHERE t.assignee.personId= :personId")
    List<TodoItem> findByPersonId(@Param("personId") Integer personId);


    @Query("SELECT t FROM TodoItem t WHERE t.done = :doneStatus")
    List<TodoItem> findByDoneStatus(@Param("doneStatus") Boolean doneStatus);

    @Query("SELECT t FROM TodoItem t WHERE t.deadLine between :start AND :end")
    List<TodoItem> findByDeadLineBetween(@Param("start") LocalDate start, @Param("end") LocalDate end);


    @Query("SELECT t FROM TodoItem t WHERE t.deadLine > :date")
    List<TodoItem> findByDeadLineAfter(@Param("date") LocalDate date);


    @Query("SELECT t FROM TodoItem t WHERE t.deadLine < :date")
    List<TodoItem> findByDeadLineBefore(@Param("date") LocalDate date);

    @Query("SELECT t FROM TodoItem t WHERE t.assignee IS null ")
    List<TodoItem> findUnassignedTodoItems();


    @Query("SELECT t FROM TodoItem t WHERE t.done IS false AND current_date > t.deadLine")
    List<TodoItem> findByUnfinishedAndOverdue();
}
