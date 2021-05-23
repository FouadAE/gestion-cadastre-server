package com.example.demo.dao;

import com.example.demo.bean.Cadastre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastreDao extends JpaRepository<Cadastre,Long> {

    Cadastre findByRef(String ref);

    int deleteByRef(String ref);
}
