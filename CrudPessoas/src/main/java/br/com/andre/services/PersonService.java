package br.com.andre.services;

import br.com.andre.converter.DozerConverter;
import br.com.andre.exception.ResourceNotFoundException;
import br.com.andre.model.Person;
import br.com.andre.model.dto.PersonDTO;
import br.com.andre.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonDTO create(PersonDTO personDTO) {
        Person entity = DozerConverter.parseObject(personDTO, Person.class);
        PersonDTO dto = DozerConverter.parseObject(personRepository.save(entity), PersonDTO.class);
//        BeanUtils.copyProperties(personDTO, person);
        return dto;
    }

    public PersonDTO update(PersonDTO personDTO) {
        Person entity = personRepository
                .findById(personDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID."));
//        BeanUtils.copyProperties(personDTO, entity);
        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setAddress(personDTO.getAddress());
        entity.setGender(personDTO.getGender());

        return DozerConverter.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        PersonDTO dto = findById(id);
        personRepository.delete(DozerConverter.parseObject(dto, Person.class));
    }

    public PersonDTO findById(Long id) {
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID."));
        return DozerConverter.parseObject(entity, PersonDTO.class);
    }

    public List<PersonDTO> findAll() {
        return DozerConverter.parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

}
