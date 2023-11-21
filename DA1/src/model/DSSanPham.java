
package model;


public class DSSanPham {
    private String HinhAnh;
    private String Ten;
    private String Thongtin;
    private int gia;
    private String ketcau;
    private int SoLuong;

    public DSSanPham() {
    }

    public DSSanPham(String HinhAnh, String Ten, String Thongtin, int gia, String ketcau, int SoLuong) {
        this.HinhAnh = HinhAnh;
        this.Ten = Ten;
        this.Thongtin = Thongtin;
        this.gia = gia;
        this.ketcau = ketcau;
        this.SoLuong = SoLuong;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getThongtin() {
        return Thongtin;
    }

    public void setThongtin(String Thongtin) {
        this.Thongtin = Thongtin;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getKetcau() {
        return ketcau;
    }

    public void setKetcau(String ketcau) {
        this.ketcau = ketcau;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
     public Object[] toDataRow(){
        return new Object[]{this.HinhAnh,this.Ten,this.Thongtin,this.gia,this.ketcau,this.SoLuong};
    }
    
    
}
