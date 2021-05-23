package com.example.demo.service;

import com.example.demo.bean.BienImmobilier;
import com.example.demo.bean.Cadastre;
import com.example.demo.dao.BienImmobilierDao;
import com.example.demo.vo.BienImmobilierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class BienImmobilierService {
    @Autowired
    BienImmobilierDao bienImmobilierDao;
    @Autowired
    CadastreService cadastreService;
    @Autowired
    EntityManager entityManager;


    public BienImmobilier findByTitreFoncier(String titreFoncier) {
        return bienImmobilierDao.findByTitreFoncier(titreFoncier);
    }

    public List<BienImmobilier> findByCadastreRef(String refCadastre) {
        return cadastreService.findByRef(refCadastre).getBiensImmobilier();
    }

    @Transactional
    public int deleteByTitreFoncier(String titreFoncier) {
        return bienImmobilierDao.deleteByTitreFoncier(titreFoncier);
    }

    public int deleteByCadastreRef(String cadastreRef) {
        return bienImmobilierDao.deleteByCadastreRef(cadastreRef);
    }

    public List<BienImmobilier> findAll() {
        return bienImmobilierDao.findAll();
    }

    public int save(Cadastre cadastre) {
        var ref = new Object() {
            int i = 0;
        };
        Cadastre foundedCadastre = cadastreService.findByRef(cadastre.getRef());
        if (cadastre.getBiensImmobilier() != null) {
            cadastre.getBiensImmobilier().stream().forEach(bienImmobilier -> {
                if (bienImmobilier != null && bienImmobilier.getTitreFoncier() != null && findByTitreFoncier(bienImmobilier.getTitreFoncier()) == null) {
                    bienImmobilier.setCadastre(foundedCadastre);
                    bienImmobilierDao.save(bienImmobilier);
                    ref.i++;
                }
            });
            return ref.i;

        } else return -1;

    }

    public List<BienImmobilier> findByCritere(BienImmobilierVo bienImmobilierVo) {
        String query = "SELECT b FROM BienImmobilier b where 1=1";
        if (bienImmobilierVo.getTitreFoncier() != null && !bienImmobilierVo.getTitreFoncier().isEmpty())
            query += "AND b.titreFoncier ='" + bienImmobilierVo.getTitreFoncier() + "'";
        if (bienImmobilierVo.getLocalisation() != null && !bienImmobilierVo.getLocalisation().isEmpty())
            query += "AND b.localisation ='" + bienImmobilierVo.getLocalisation() + "'";
        if (bienImmobilierVo.getMaxSurface() != null && !bienImmobilierVo.getMinSurface().isEmpty())
            query += "AND b.surface <='" + bienImmobilierVo.getMaxSurface() + "'";
        if (bienImmobilierVo.getMinSurface() != null && !bienImmobilierVo.getMinSurface().isEmpty())
            query += "AND b.surface >='" + bienImmobilierVo.getMinSurface() + "'";

        return entityManager.createQuery(query).getResultList();
    }

}
