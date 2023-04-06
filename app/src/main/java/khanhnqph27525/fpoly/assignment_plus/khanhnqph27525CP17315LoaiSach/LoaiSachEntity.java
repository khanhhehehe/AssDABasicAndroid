package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_loaiSach")
public class LoaiSachEntity {
    @PrimaryKey(autoGenerate = true)
    private int khanhnqph27525CP17315idloaisach;
    private int khanhnqph27525CP17315maLoai;
    private String khanhnqph27525CP17315tenLoai;
    private int khanhnqph27525CP17315imgDelete;

    public LoaiSachEntity() {
    }

    public LoaiSachEntity(int khanhnqph27525CP17315maLoai, String khanhnqph27525CP17315tenLoai) {
        this.khanhnqph27525CP17315maLoai = khanhnqph27525CP17315maLoai;
        this.khanhnqph27525CP17315tenLoai = khanhnqph27525CP17315tenLoai;
    }

    public int getKhanhnqph27525CP17315idloaisach() {
        return khanhnqph27525CP17315idloaisach;
    }

    public void setKhanhnqph27525CP17315idloaisach(int khanhnqph27525CP17315idloaisach) {
        this.khanhnqph27525CP17315idloaisach = khanhnqph27525CP17315idloaisach;
    }

    public int getKhanhnqph27525CP17315maLoai() {
        return khanhnqph27525CP17315maLoai;
    }

    public void setKhanhnqph27525CP17315maLoai(int khanhnqph27525CP17315maLoai) {
        this.khanhnqph27525CP17315maLoai = khanhnqph27525CP17315maLoai;
    }

    public String getKhanhnqph27525CP17315tenLoai() {
        return khanhnqph27525CP17315tenLoai;
    }

    public void setKhanhnqph27525CP17315tenLoai(String khanhnqph27525CP17315tenLoai) {
        this.khanhnqph27525CP17315tenLoai = khanhnqph27525CP17315tenLoai;
    }

    public int getKhanhnqph27525CP17315imgDelete() {
        return khanhnqph27525CP17315imgDelete;
    }

    public void setKhanhnqph27525CP17315imgDelete(int khanhnqph27525CP17315imgDelete) {
        this.khanhnqph27525CP17315imgDelete = khanhnqph27525CP17315imgDelete;
    }
}
