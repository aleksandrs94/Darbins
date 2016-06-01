package com.example.kriss.galadarbs;


public class DataProvider {

    private String nosaukums;
    private String datums;
    private String cena;
    private String info;

    public String getNosaukums() {
        return nosaukums;
    }

    public void setNosaukums(String nosaukums) {
        this.nosaukums = nosaukums;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getDatums() {
        return datums;
    }

    public void setDatums(String datums) {
        this.datums = datums;
    }

    public DataProvider(String nosaukums, String datums, String cena, String info)
    {
        this.nosaukums = nosaukums;
        this.datums = datums;
        this.cena = cena;
        this.info = info;

    }

}
