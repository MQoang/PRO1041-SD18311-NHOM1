/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Luong {
      private int id;
     private int luong;
        private int thoigian;
     private int ca;
  


    public Luong() {
    }

    public Luong(int id, int luong, int thoigian, int ca) {
        this.id = id;
        this.luong = luong;
        this.thoigian = thoigian;
        this.ca = ca;
    }

   
    @Override
    public String toString() {
        return "Luong{" + "id=" + id + ", luong=" + luong + ", thoigian=" + thoigian + ", ca=" + ca + '}';
    }

   

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
}
