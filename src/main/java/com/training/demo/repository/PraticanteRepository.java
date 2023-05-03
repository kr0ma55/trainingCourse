package com.training.demo.repository;

import com.training.demo.model.Praticante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface PraticanteRepository extends JpaRepository<Praticante, Id>
{
    Praticante getByNickName(String nickName);


    @Query(value = "SELECT NICK_NAME FROM PRATICANTE WHERE NICK_NAME = :nickName",nativeQuery = true)
    String findByNickNameNative(String nickName);
}