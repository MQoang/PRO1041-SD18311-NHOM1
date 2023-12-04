/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tom
 */
public class MaVoucher {

    private int id;
    private int phanTram;
    private int soLuong;

    public MaVoucher() {
    }

    public MaVoucher(int id, int phanTram, int soLuong) {
        this.id = id;
        this.phanTram = phanTram;
        this.soLuong = soLuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(int phanTram) {
        this.phanTram = phanTram;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "MaVoucher{" + "id=" + id + ", phanTram=" + phanTram + ", soLuong=" + soLuong + '}';
    }

}
