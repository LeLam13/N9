/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author admin
 */
public class NhanVienService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<NhanVien> getAll() {
        sql = "select manv,hoten,tuoi,diachi,email,sdt,gioitinh,roles from nhanvien";
        List<NhanVien> list = new ArrayList<>();
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public int add(NhanVien nv) {
        sql = "insert into nhanvien(manv,hoten,tuoi,diachi,email,sdt,gioitinh,roles,matkhau) values(?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getManv());
            ps.setObject(2, nv.getHoten());
            ps.setObject(3, nv.getTuoi());
            ps.setObject(4, nv.getDiachi());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.isGioitinh());
            ps.setObject(8, nv.isVaitro());
            ps.setObject(9, nv.getMatkhau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(NhanVien nv, String ma) {
        sql = "update nhanvien set manv=?,hoten=?,tuoi=?,diachi=?,email=?,sdt=?,gioitinh=?,roles=? where manv=?";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getManv());
            ps.setObject(2, nv.getHoten());
            ps.setObject(3, nv.getTuoi());
            ps.setObject(4, nv.getDiachi());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.isGioitinh());
            ps.setObject(8, nv.isVaitro());
            ps.setObject(9, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String ma) {
        sql = "delete nhanvien where manv=?";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
