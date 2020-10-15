package br.com.andre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class PersonDTO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonDTO() { }

}
