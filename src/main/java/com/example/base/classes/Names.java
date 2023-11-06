package com.example.base.classes;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Names {

    private MessageSource messageSource;

    public Names(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(path="/names")
    public List<Name> retriveAllTheNames(){

        return Arrays.asList(
                new Name(1,"Anuma","85%"),
                new Name(2,"Ajith","95%")
        );
    }
    @GetMapping(path="/peruu/{nama}")
    public Name getNameUsingPathVariable(@PathVariable String nama){
       return new Name(String.format("Hello Guys your leader is,%s",nama));
    }
    @GetMapping(path="/helloWorldInternationalization")
    public String helloWorldInternationalization(){
    Locale locale= LocaleContextHolder.getLocale();
     return messageSource.getMessage("good.morning.message",null,"Default Message", locale);
    }
}
