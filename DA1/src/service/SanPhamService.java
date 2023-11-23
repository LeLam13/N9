/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author admin
 */
public class SanPhamService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<SanPham> getAll() {
        sql = "select mactsp,sanpham.masp,tensp,soluong,gia,ketcau,thetich,theloai,mota,trangthai from sanpham join ctsanpham on sanpham.masp=ctsanpham.masp join dungtich on dungtich.madt=ctsanpham.madt join chamsoc on chamsoc.macs=ctsanpham.macs";
        List<SanPham> list = new ArrayList<>();
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getBoolean(10));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getMaSP() {
        sql = "select masp from sanpham";
        List<String> list = new ArrayList<>();
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String masp = rs.getString(1);
                list.add(masp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int addsp(SanPham sp) {
        sql = "insert into sanpham(masp,tensp,mota) values(?,?,?)";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMasp());
            ps.setObject(2, sp.getTensp());
            ps.setObject(3, sp.getMota());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int addct(SanPham sp) {
        sql = "insert into ctsanpham(soluong,gia,ketcau,madt,macs,masp,trangthai) values(?,?,?,?,?,?,?)";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getSoluong());
            ps.setObject(2, sp.getGia());
            ps.setObject(3, sp.getKetcau());
            ps.setObject(4, sp.getIdTheTich());
            ps.setObject(5, sp.getIdTheLoai());
            ps.setObject(6, sp.getMasp());
            ps.setObject(7, sp.isTrangthai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

   
    
    public int deletectsp(String masp) {    
        sql = "delete ctsanpham where masp=?";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, masp);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deletect(int mactsp) {
        sql = "delete ctsanpham where mactsp=?";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, mactsp);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updatect(SanPham sp, String ma) {
        sql = "update ctsanpham set soluong=?,gia=?,ketcau=?,madt=?,macs=?,masp=?,trangthai=? where mactsp=?";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getSoluong());
            ps.setObject(2, sp.getGia());
            ps.setObject(3, sp.getKetcau());
            ps.setObject(4, sp.getIdTheTich());
            ps.setObject(5, sp.getIdTheLoai());
            ps.setObject(6, sp.getMasp());
            ps.setObject(7, sp.isTrangthai());
            ps.setObject(8, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updatesp(SanPham sp, String masp) {
        sql = "update sanpham set masp=?,tensp=?,mota=? where masp=?";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMasp());
            ps.setObject(2, sp.getTensp());
            ps.setObject(3, sp.getMota());
            ps.setObject(4, masp);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<String> cbxTheLoai() {
        sql = """
           SELECT
                 [theloai]
             FROM [PMQL].[dbo].[chamsoc]
           """;
        List<String> listItem = new ArrayList<>();
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String TL = rs.getString(1);
                listItem.add(TL);
            }
            return listItem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> cbxDungTich() {
        sql = """
           SELECT 
                 [thetich]
             FROM [PMQL].[dbo].[dungtich]
           """;
        List<String> listItem = new ArrayList<>();
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String DT = rs.getString(1);
                listItem.add(DT);
            }
            return listItem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getIdTheLoai(String tenTheLoai) {
        sql = """
              SELECT [macs]
                    
                FROM [PMQL].[dbo].[chamsoc]
                Where theloai = ?
               """;
        String TL1 = "";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tenTheLoai);
            rs = ps.executeQuery();
            while (rs.next()) {
                TL1 = rs.getString(1);
            }
            return TL1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getIdTheTich(String tenTheTich) {
        sql = """
            SELECT  [madt]
              FROM [PMQL].[dbo].[dungtich]
              where thetich = ?
               """;
        String TT1 = "";
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tenTheTich);

            rs = ps.executeQuery();
            while (rs.next()) {
                TT1 = rs.getString(1);
            }
            return TT1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
