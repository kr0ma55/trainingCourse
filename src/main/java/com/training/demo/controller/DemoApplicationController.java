package com.training.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.demo.model.Studente;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class DemoApplicationController {


    /* Invocazione: http://localhost:8080/hello/marco */

    @GetMapping(path="/hello/{name}")
    public String hello(@PathVariable String name)
        {
            return "Hello" + name;
        }
    @GetMapping(path="/hello")
    public String helloDue(@RequestParam String name)
    {
        return "Hello" + name;
    }

    @RequestMapping(value = "/helloMyName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity helloMyName(HttpServletRequest req, @RequestParam String name,@RequestParam String biname) {
        String concat;
        try {
            concat = name + " " + biname;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(concat);
    }

    @RequestMapping(value = "/postMyName", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postMyNameMarco(HttpServletRequest req, @RequestBody String objectRequest) {

        Studente nuovoStudente = new Studente("","","");
        try {
            ObjectMapper mapper = new ObjectMapper();
            nuovoStudente = mapper.readValue(objectRequest, new TypeReference<Studente>(){});

            nuovoStudente.setSurname("Ognibene");


        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(nuovoStudente);
    }



}
