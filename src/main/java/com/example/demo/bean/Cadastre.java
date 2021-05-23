package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
@Entity
public class Cadastre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String description;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "cadastre")
    private List<BienImmobilier> biensImmobilier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BienImmobilier> getBiensImmobilier() {
        return biensImmobilier;
    }

    public void setBiensImmobilier(List<BienImmobilier> biensImmobilier) {
        this.biensImmobilier = biensImmobilier;
    }
}
