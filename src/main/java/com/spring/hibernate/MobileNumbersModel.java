package com.spring.hibernate;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mobile_numbers")
public class MobileNumbersModel {

    @Id
    @GeneratedValue(generator = "newGenerator")
    @GenericGenerator(name = "newGenerator", strategy = "foreign" , parameters = { @Parameter(name = "property", value = "birimObjectModel")})
    private int id;

    private long mobile_no;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private BirimObjectModel birimObjectModel;


    public long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public BirimObjectModel getBirimObjectModel() {
        return birimObjectModel;
    }

    public void setBirimObjectModel(BirimObjectModel birimObjectModel) {
        this.birimObjectModel = birimObjectModel;
    }

}
