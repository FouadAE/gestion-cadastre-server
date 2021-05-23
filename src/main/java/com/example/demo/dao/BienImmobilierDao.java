package com.example.demo.dao;

import com.example.demo.bean.BienImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BienImmobilierDao extends JpaRepository<BienImmobilier, Long> {
    BienImmobilier findByTitreFoncier(String titreFoncier);

    int deleteByTitreFoncier(String titreFoncier);

    int deleteByCadastreRef(String cadastreRef);


}
