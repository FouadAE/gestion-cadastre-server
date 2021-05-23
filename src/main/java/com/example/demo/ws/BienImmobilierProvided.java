package com.example.demo.ws;


import com.example.demo.bean.BienImmobilier;
import com.example.demo.bean.Cadastre;
import com.example.demo.service.BienImmobilierService;
import com.example.demo.vo.BienImmobilierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion-cadastre-foncier-2/bienimmobilier")
public class BienImmobilierProvided {
    @Autowired
    BienImmobilierService bienImmobilierService;

    @GetMapping("/titreFoncier/{titreFoncier}")
    public BienImmobilier findByTitreFoncier(@PathVariable String titreFoncier) {
        return bienImmobilierService.findByTitreFoncier(titreFoncier);
    }

    @DeleteMapping("/titreFoncier/{titreFoncier}")
    public int deleteByTitreFoncier(@PathVariable String titreFoncier) {
        return bienImmobilierService.deleteByTitreFoncier(titreFoncier);
    }

    @DeleteMapping("/cadastreRef/{cadastreRef}")
    public int deleteByCadastreRef(@PathVariable String cadastreRef) {
        return bienImmobilierService.deleteByCadastreRef(cadastreRef);
    }

    @GetMapping("/")
    public List<BienImmobilier> findAll() {
        return bienImmobilierService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Cadastre cadastre) {
        return bienImmobilierService.save(cadastre);
    }

    @GetMapping("/refCadastre/{refCadastre}")
    public List<BienImmobilier> findByCadastreRef(@PathVariable String refCadastre) {
        return bienImmobilierService.findByCadastreRef(refCadastre);
    }

    @PostMapping("/critere")
    public List<BienImmobilier> findBycritere(@RequestBody BienImmobilierVo bienImmobilierVo) {
        return bienImmobilierService.findByCritere(bienImmobilierVo);
    }
}
