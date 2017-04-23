package com.spring.CustomClasses;

import java.util.ArrayList;

public class BirimObject {
    private int birimId;
    private String birimAdi;
    private long ustBirimId;
    private ArrayList<BirimObject> altMenuler;

    public BirimObject(int birimId, String birimAdi, long ustBirimId,ArrayList<BirimObject> altMenuler ) {
        this.birimId = birimId;
        this.birimAdi = birimAdi;
        this.ustBirimId = ustBirimId;
        this.setAltMenuler(altMenuler);
    }

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

    public ArrayList<BirimObject> getAltMenuler() {
        return altMenuler;
    }

    public void setAltMenuler(ArrayList<BirimObject> altMenuler) {
        this.altMenuler = altMenuler;
    }
}
