/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class SanPham {
    private String masp,tensp;
    private int soluong;
    private float gia;
    private String ketcau,mota;
    private String idTheLoai;
    private String idTheTich;
    private int mact;

    
    

    public SanPham(String masp, String tensp, String mota) {
        this.masp = masp;
        this.tensp = tensp;
        this.mota = mota;
    }

    public int getMact() {
        return mact;
    }

    public void setMact(int mact) {
        this.mact = mact;
    }
    
    

    public String getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(String idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public String getIdTheTich() {
        return idTheTich;
    }

    public void setIdTheTich(String idTheTich) {
        this.idTheTich = idTheTich;
    }

    public SanPham(int mact, String masp, String tensp, int soluong, float gia, String ketcau, String idTheTich, String idTheLoai, String mota ) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.gia = gia;
        this.ketcau = ketcau;
        this.mota = mota;
        this.idTheLoai = idTheLoai;
        this.idTheTich = idTheTich;
        this.mact = mact;
    }





    

   

    public SanPham() {
    }

    public SanPham(String masp, String tensp, int soluong, float gia, String ketcau, String mota) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.gia = gia;
        this.ketcau = ketcau;
        this.mota = mota;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getKetcau() {
        return ketcau;
    }

    public void setKetcau(String ketcau) {
        this.ketcau = ketcau;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return this.getMasp();
    }
    
}
