/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Quanglm
 */
public class IMEI {
    private String maBienThe;
    private String maIMEI;

    public IMEI() {
    }

    public IMEI(String maBienThe, String maIMEI) {
        this.maBienThe = maBienThe;
        this.maIMEI = maIMEI;
    }

    @Override
    public String toString() {
        return "IMEI{" + "maBienThe=" + maBienThe + ", maIMEI=" + maIMEI + '}';
    }

    public String getMaBienThe() {
        return maBienThe;
    }

    public void setMaBienThe(String maBienThe) {
        this.maBienThe = maBienThe;
    }

    public String getMaIMEI() {
        return maIMEI;
    }

    public void setMaIMEI(String maIMEI) {
        this.maIMEI = maIMEI;
    }
    
    
}
