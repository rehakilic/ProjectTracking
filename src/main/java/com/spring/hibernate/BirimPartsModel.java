package com.spring.hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Birim_Parcasi")
public class BirimPartsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String birimPartName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "birimPartsModel", fetch = FetchType.LAZY)
    private Set<BirimObjectModel> birimObjectModels = new HashSet<BirimObjectModel>();


    public String getBirimPartName() {
        return birimPartName;
    }

    public void setBirimPartName(String birimPartName) {
        this.birimPartName = birimPartName;
    }

    public Set<BirimObjectModel> getBirimObjectModels() {
        return birimObjectModels;
    }

    public void setBirimObjectModels(Set<BirimObjectModel> birimObjectModels) {
        this.birimObjectModels = birimObjectModels;
    }
}
