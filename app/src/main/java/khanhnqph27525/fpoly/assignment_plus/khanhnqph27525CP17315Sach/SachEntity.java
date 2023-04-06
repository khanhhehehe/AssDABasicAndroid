package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_sach")
public class SachEntity {
    @PrimaryKey(autoGenerate = true)
    private int khanhnqph27525CP17315idsach;
    private int khanhnqph27525CP17315maSach;
    private String khanhnqph27525CP17315tenSach;
    private int khanhnqph27525CP17315giaThue;
    private String khanhnqph27525CP17315tenLoai;
    private String khanhnqph27525CP17315tacGia;
    private int khanhnqph27525CP17315imgDelete;

    public SachEntity() {
    }

    public SachEntity(int khanhnqph27525CP17315maSach, String khanhnqph27525CP17315tenSach, int khanhnqph27525CP17315giaThue, String khanhnqph27525CP17315tenLoai, String khanhnqph27525CP17315tacGia) {
        this.khanhnqph27525CP17315maSach = khanhnqph27525CP17315maSach;
        this.khanhnqph27525CP17315tenSach = khanhnqph27525CP17315tenSach;
        this.khanhnqph27525CP17315giaThue = khanhnqph27525CP17315giaThue;
        this.khanhnqph27525CP17315tenLoai = khanhnqph27525CP17315tenLoai;
        this.khanhnqph27525CP17315tacGia = khanhnqph27525CP17315tacGia;
    }

    public int getKhanhnqph27525CP17315idsach() {
        return khanhnqph27525CP17315idsach;
    }

    public void setKhanhnqph27525CP17315idsach(int khanhnqph27525CP17315idsach) {
        this.khanhnqph27525CP17315idsach = khanhnqph27525CP17315idsach;
    }

    public int getKhanhnqph27525CP17315maSach() {
        return khanhnqph27525CP17315maSach;
    }

    public void setKhanhnqph27525CP17315maSach(int khanhnqph27525CP17315maSach) {
        this.khanhnqph27525CP17315maSach = khanhnqph27525CP17315maSach;
    }

    public String getKhanhnqph27525CP17315tenSach() {
        return khanhnqph27525CP17315tenSach;
    }

    public void setKhanhnqph27525CP17315tenSach(String khanhnqph27525CP17315tenSach) {
        this.khanhnqph27525CP17315tenSach = khanhnqph27525CP17315tenSach;
    }

    public int getKhanhnqph27525CP17315giaThue() {
        return khanhnqph27525CP17315giaThue;
    }

    public void setKhanhnqph27525CP17315giaThue(int khanhnqph27525CP17315giaThue) {
        this.khanhnqph27525CP17315giaThue = khanhnqph27525CP17315giaThue;
    }

    public String getKhanhnqph27525CP17315tenLoai() {
        return khanhnqph27525CP17315tenLoai;
    }

    public void setKhanhnqph27525CP17315tenLoai(String khanhnqph27525CP17315tenLoai) {
        this.khanhnqph27525CP17315tenLoai = khanhnqph27525CP17315tenLoai;
    }

    public String getKhanhnqph27525CP17315tacGia() {
        return khanhnqph27525CP17315tacGia;
    }

    public void setKhanhnqph27525CP17315tacGia(String khanhnqph27525CP17315tacGia) {
        this.khanhnqph27525CP17315tacGia = khanhnqph27525CP17315tacGia;
    }

    public int getKhanhnqph27525CP17315imgDelete() {
        return khanhnqph27525CP17315imgDelete;
    }

    public void setKhanhnqph27525CP17315imgDelete(int khanhnqph27525CP17315imgDelete) {
        this.khanhnqph27525CP17315imgDelete = khanhnqph27525CP17315imgDelete;
    }
}
