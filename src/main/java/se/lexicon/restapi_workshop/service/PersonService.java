package se.lexicon.restapi_workshop.service;


import se.lexicon.restapi_workshop.model.dto.PersonDto;
import se.lexicon.restapi_workshop.model.form.PersonForm;

import java.util.List;

public interface PersonService {


    public PersonDto create(PersonForm form);

    public PersonDto findById(Integer Id);

    public List<PersonDto> findAll();

    public List<PersonDto> findIdlePeople();

    public PersonDto update(Integer Id, PersonDto personDto);

    public Boolean delete(Integer Id);

    public PersonDto addTodoItem(Integer personId, Integer todoItemId);

    public PersonDto removeTodoItem(Integer personId, Integer todoItemId);









}
