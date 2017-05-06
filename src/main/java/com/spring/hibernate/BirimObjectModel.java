package com.spring.hibernate;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "test")
public class BirimObjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int birimId;

    @Column(name = "Adi", nullable = false)
    private String birimAdi;

    @Transient
    private long ustBirimId;

    @Temporal(TemporalType.DATE)
    private Date createdDate;



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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
