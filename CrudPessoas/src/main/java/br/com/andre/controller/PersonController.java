package br.com.andre.controller;

import br.com.andre.model.Person;
import br.com.andre.model.dto.PersonDTO;
import br.com.andre.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable("id") Long id, @RequestBody PersonDTO personDTO) {
        personDTO.setId(id);
        return personService.update(personDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
