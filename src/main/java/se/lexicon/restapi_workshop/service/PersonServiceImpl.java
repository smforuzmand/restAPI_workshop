package se.lexicon.restapi_workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.restapi_workshop.data.PersonDAO;
import se.lexicon.restapi_workshop.data.TodoItemDAO;
import se.lexicon.restapi_workshop.model.dto.PersonDto;
import se.lexicon.restapi_workshop.model.entity.Person;
import se.lexicon.restapi_workshop.model.form.PersonForm;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService{


    private final PersonDAO personDAO;
    private final TodoItemDAO todoItemDAO;
    private final ServiceConverting converting;


    @Autowired
    public PersonServiceImpl(PersonDAO personDAO, TodoItemDAO todoItemDAO, ServiceConverting converting) {
        this.personDAO = personDAO;
        this.todoItemDAO = todoItemDAO;
        this.converting = converting;
    }


    @Transactional
    @Override
    public PersonDto create(PersonForm form) {
//        form -> entity -> DTO
        Person personSave = personDAO.save(converting.toPerson(form));
        return converting.toPersonDto(personSave);
    }

    @Override
    public PersonDto findById(Integer Id) {

        Optional<Person> foundById = personDAO.findById(Id);
        Person person = foundById.orElseThrow(() -> new IllegalArgumentException("Could not find Person By Id" + Id));
        return converting.toPersonDto(person);
    }

    @Override
    public List<PersonDto> findAll() {
        return null;
    }

    @Override
    public List<PersonDto> findIdlePeople() {
        return null;
    }

    @Override
    public PersonDto update(Integer Id, PersonDto personDto) {
        return null;
    }

    @Override
    public Boolean delete(Integer Id) {
        return null;
    }

    @Override
    public PersonDto addTodoItem(Integer personId, Integer todoItemId) {
        return null;
    }

    @Override
    public PersonDto removeTodoItem(Integer personId, Integer todoItemId) {
        return null;
    }
}
