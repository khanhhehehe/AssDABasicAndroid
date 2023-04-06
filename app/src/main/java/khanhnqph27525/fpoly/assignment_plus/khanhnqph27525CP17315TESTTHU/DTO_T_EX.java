package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315TESTTHU;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_sanPham")
public class DTO_T_EX {
    @PrimaryKey(autoGenerate = true)
    private int idsanPham;
    private String loaiSp;
    private String maSp;
    private String tenSp;
    private int soLuong;
    private int donGia;
    private String hanSd;

    public DTO_T_EX() {
    }

    public DTO_T_EX(String loaiSp, String maSp, String tenSp, int soLuong, int donGia, String hanSd) {
        this.loaiSp = loaiSp;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.hanSd = hanSd;
    }

    public int getIdsanPham() {
        return idsanPham;
    }

    public void setIdsanPham(int idsanPham) {
        this.idsanPham = idsanPham;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getHanSd() {
        return hanSd;
    }

    public void setHanSd(String hanSd) {
        this.hanSd = hanSd;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }
}
