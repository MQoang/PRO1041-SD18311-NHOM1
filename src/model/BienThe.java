/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author Quanglm
 */
public class BienThe {
    private String maBienThe;
    
    private String maSanPham;
    private String mauSac;
    private String CPU;
    private String ram;
    private String card;
    private String oCung;
    private BigDecimal giaBan;
    

    public BienThe() {
    }

    public BienThe(String maBienThe, String maSanPham, String mauSac, String CPU, String ram, String card, String oCung, BigDecimal giaBan) {
        this.maBienThe = maBienThe;
        
        this.maSanPham = maSanPham;
        this.mauSac = mauSac;
        this.CPU = CPU;
        this.ram = ram;
        this.card = card;
        this.oCung = oCung;
        this.giaBan = giaBan;
       
    }

    @Override
    public String toString() {
        return "BienThe{" + "maBienThe=" + maBienThe + ", maSanPham=" + maSanPham + ", mauSac=" + mauSac + ", CPU=" + CPU + ", ram=" + ram + ", card=" + card + ", oCung=" + oCung + ", giaBan=" + giaBan + '}';
    }

  

    public String getMaBienThe() {
        return maBienThe;
    }

    public void setMaBienThe(String maBienThe) {
        this.maBienThe = maBienThe;
    }

   

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getoCung() {
        return oCung;
    }

    public void setoCung(String oCung) {
        this.oCung = oCung;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

   
    
    
    
}
