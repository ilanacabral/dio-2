package br.com.diolabs.springwebmvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.diolabs.springwebmvc.model.Jedi;

@Repository
public class JediRepository {

    private List<Jedi> jedi;   

    public JediRepository(){
        if (jedi==null){
            this.jedi = new ArrayList<>(); 
        }
        this.jedi.add(new Jedi("Luke", "Skywalker"));
        this.jedi.add(new Jedi("Eva", "Skywalker"));      
    }

    public List<Jedi> getAllJedi(){       
       return this.jedi;
    }

    public void createJedi(Jedi jedi){
        this.jedi.add(jedi);       
    }
    
    
}
