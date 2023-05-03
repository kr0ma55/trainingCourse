package com.training.demo.service;

import com.training.demo.model.Praticante;
import com.training.demo.repository.PraticanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {


    @Autowired
    PraticanteRepository praticanteRepository;

    public List<Praticante> findAll(){
        //Praticante praticRecuperato = praticanteRepository.getByNickName(nickName);
        List<Praticante> praticStringList =  praticanteRepository.findAll();

        return praticStringList;
    }
}
