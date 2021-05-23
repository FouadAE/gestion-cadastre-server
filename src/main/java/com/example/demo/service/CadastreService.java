package com.example.demo.service;

import com.example.demo.bean.Cadastre;
import com.example.demo.dao.CadastreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastreService {
    @Autowired
    private CadastreDao cadastreDao;
    @Autowired
    private BienImmobilierService bienImmobilierService;

    public Cadastre findByRef(String ref) {
        return cadastreDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        int res = bienImmobilierService.deleteByCadastreRef(ref);
        res += cadastreDao.deleteByRef(ref);
        return res;
    }

    public List findAll() {
        return cadastreDao.findAll();
    }
    public int save(Cadastre cadastre) {
        if (findByRef(cadastre.getRef()) != null) {
            return -1;
        } else {
            cadastreDao.save(cadastre);
            bienImmobilierService.save(cadastre);
            return 1;
        }
    }
}
