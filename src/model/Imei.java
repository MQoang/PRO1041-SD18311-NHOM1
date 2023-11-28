/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Quanglm
 */
public class Imei {
    private String maBienThe;
    private String maImei;

    public Imei() {
    }

    public Imei(String maBienThe, String maImei) {
        this.maBienThe = maBienThe;
        this.maImei = maImei;
    }

    public String getMaBienThe() {
        return maBienThe;
    }

    public void setMaBienThe(String maBienThe) {
        this.maBienThe = maBienThe;
    }

    public String getMaImei() {
        return maImei;
    }

    public void setMaImei(String maImei) {
        this.maImei = maImei;
    }

    @Override
    public String toString() {
        return "Imei{" + "maBienThe=" + maBienThe + ", maImei=" + maImei + '}';
    }
    
    
}
