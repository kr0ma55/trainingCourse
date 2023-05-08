package com.training.demo.service;

import com.training.demo.model.Praticante;
import com.training.demo.repository.PraticanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {


    @Autowired
    PraticanteRepository praticanteRepository;

    public Optional<Praticante> findById(Long id){
        //Praticante praticRecuperato = praticanteRepository.getByNickName(nickName);
        Optional praticante =  praticanteRepository.findById(id);
        return praticante;
    }

    public List<Praticante> findAll(){
        List<Praticante> praticanteList =  praticanteRepository.findAll();
        return praticanteList;
    }

    public Praticante addNew(Praticante praticante){
        Praticante nuovoPraticante =  praticanteRepository.save(praticante);
        return nuovoPraticante;
    }
}
