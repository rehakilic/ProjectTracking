package com.spring.hibernate;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Birim_Object")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "birimId")
    private MobileNumbersModel mobileNumbersModel;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "birim_parcasi_id")
    private BirimPartsModel birimPartsModel;

    //@ManyToOne(cascade = CascadeType.ALL)
    //private BirimPartsModel birimPartsModel;

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

    public MobileNumbersModel getMobileNumbersModel() {
        return mobileNumbersModel;
    }

    public void setMobileNumbersModel(MobileNumbersModel mobileNumbersModel) {
        this.mobileNumbersModel = mobileNumbersModel;
    }

//    public BirimPartsModel getBirimPartsModel() {
//        return birimPartsModel;
//    }
//
//    public void setBirimPartsModel(BirimPartsModel birimPartsModel) {
//        this.birimPartsModel = birimPartsModel;
//    }
}
