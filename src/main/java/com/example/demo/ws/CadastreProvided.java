package com.example.demo.ws;


import com.example.demo.bean.Cadastre;
import com.example.demo.service.CadastreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-cadastre-foncier-2/cadastre")
public class CadastreProvided {

    @Autowired
    private CadastreService cadastreService;

    @GetMapping("/ref/{ref}")
    public Cadastre findByRef(@PathVariable String ref) {
        return cadastreService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return cadastreService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List findAll() {
        return cadastreService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Cadastre cadastre) {
        return cadastreService.save(cadastre);
    }
}
