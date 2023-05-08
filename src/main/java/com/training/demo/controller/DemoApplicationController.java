package com.training.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.demo.model.Praticante;
import com.training.demo.model.Studente;
import com.training.demo.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DemoApplicationController {

    @Autowired
    TrainingService trainingService;
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
            return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(concat);
    }

    @RequestMapping(value = "/getpraticantebyid", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPraticanteById(HttpServletRequest req,@RequestParam Long id ) {
        Optional praticante ;
        try {
            praticante = trainingService.findById(id);
            if(praticante.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(praticante.get());
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


    //REAL SERVICES
    @RequestMapping(value = "/postnuovopraticante", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postNuovoPraticante(HttpServletRequest req, @RequestBody String objectRequest) {

        Praticante nuovoPraticanteCreato = new Praticante();
        Praticante praticanteMappatoDallaRichiesta = new Praticante();
        try {
            ObjectMapper mapper = new ObjectMapper();
            praticanteMappatoDallaRichiesta = mapper.readValue(objectRequest, new TypeReference<Praticante>(){});

            nuovoPraticanteCreato = trainingService.addNew(praticanteMappatoDallaRichiesta);

        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(nuovoPraticanteCreato);
    }

    @RequestMapping(value = "/getallpraticanti", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPraticanti(HttpServletRequest req ) {
        List<Praticante> praticanteList = new ArrayList<Praticante>();
        try {
            praticanteList = trainingService.findAll();
            if(praticanteList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(praticanteList);
    }

    @RequestMapping(value = "/getnamebyid", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity helloMyName(HttpServletRequest req,@RequestParam String nickName ) {
        //Praticante praticante = new Praticante();
        List<Praticante> praticante = new ArrayList<Praticante>();
        try {
            praticante = trainingService.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(praticante);
    }



}
