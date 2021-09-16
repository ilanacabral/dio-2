package br.com.diolabs.springwebmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.diolabs.springwebmvc.model.Jedi;
import br.com.diolabs.springwebmvc.repository.JediRepository;

@Controller
public class JediController {

    @Autowired
    private JediRepository jediRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/jedi")    
    public ModelAndView jedi() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/jedi/jedi");       
        mv.addObject("allJedi", jediRepository.getAllJedi());

        return mv;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/jedi/new-jedi");
        mv.addObject("jedi", new Jedi());
        return mv;
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result,RedirectAttributes redirectAttributes) {

        if (result.hasErrors()){
            return "/jedi/new-jedi";
        }

        jediRepository.createJedi(jedi);

        redirectAttributes.addFlashAttribute("message", "Jedi CADASTRADO COM SUCESSO");
        return "redirect:/jedi";
       
    }

}
