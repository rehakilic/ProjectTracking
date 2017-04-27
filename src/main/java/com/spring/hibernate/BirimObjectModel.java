package com.spring.hibernate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class BirimObjectModel {
    @Id
    private int birimId;
    private String birimAdi;
    private long ustBirimId;

    public int getBirimId() {
        return birimId;
    }

    public void setBirimId(int birimId) {
        this.birimId = birimId;
    }

    public String getBirimAdi() {
        return birimAdi;
    }

    public void setBirimAdi(String birimAdi) {
        this.birimAdi = birimAdi;
    }

    public long getUstBirimId() {
        return ustBirimId;
    }

    public void setUstBirimId(long ustBirimId) {
        this.ustBirimId = ustBirimId;
    }

}
