package com.spring.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "Birim_Parcasi")
public class BirimPartsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String birimPartName;

    public String getBirimPartName() {
        return birimPartName;
    }

    public void setBirimPartName(String birimPartName) {
        this.birimPartName = birimPartName;
    }
}
