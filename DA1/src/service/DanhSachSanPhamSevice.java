package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DSSanPham;

public class DanhSachSanPhamSevice {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<DSSanPham> getAll() {
        sql = "select ctsanpham.masp,tensp,mota,gia,ketcau,soluong from sanpham join ctsanpham on sanpham.masp=ctsanpham.masp";
        List<DSSanPham> list = new ArrayList<>();
        try {
            con = DBConnect.DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DSSanPham sp = new DSSanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
