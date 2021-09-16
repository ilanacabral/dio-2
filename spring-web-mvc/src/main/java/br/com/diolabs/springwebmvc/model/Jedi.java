package br.com.diolabs.springwebmvc.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Jedi {

    public Jedi() {
    }

    @NotBlank  
    private String nome;

    @NotBlank
    private String sobrenome;
    

}
