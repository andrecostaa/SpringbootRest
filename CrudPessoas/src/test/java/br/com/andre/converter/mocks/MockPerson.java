package br.com.andre.converter.mocks;

import br.com.andre.model.Person;
import br.com.andre.model.dto.PersonDTO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> people = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            people.add(mockEntity(i));
        }
        return people;
    }

    public List<PersonDTO> mockDTOList() {
        List<PersonDTO> peopleDTO = new ArrayList<PersonDTO>();
        for (int i = 0; i < 14; i++) {
            peopleDTO.add(mockDTO(i));
        }
        return peopleDTO;
    }

    private Person mockEntity(Integer number) {
        Person person = new Person();
        person.setId(number.longValue());
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setLastName("Last Name Test" + number);
        person.setGender((number % 2 == 0 ? "Male" : "Female"));
        return person;
    }

    private PersonDTO mockDTO(Integer number) {
        PersonDTO dto = new PersonDTO();
        dto.setId(number.longValue());
        dto.setAddress("Address Test" + number);
        dto.setFirstName("First Name Test" + number);
        dto.setLastName("Last Name Test" + number);
        dto.setGender((number % 2 == 0 ? "Male" : "Female"));
        return dto;
    }

}
