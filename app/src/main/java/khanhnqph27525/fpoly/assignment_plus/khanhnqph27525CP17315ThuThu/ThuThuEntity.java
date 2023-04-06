package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThuThu;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_thuThu")
public class ThuThuEntity {
    @PrimaryKey(autoGenerate = true)
    private int khanhnqph27525CP17315idthuthu;
    private String khanhnqph27525CP17315maTT;
    private String khanhnqph27525CP17315hoTen;
    private String khanhnqph27525CP17315matKhau;
    private int khanhnqph27525CP17315imgDelete;

    public ThuThuEntity() {
    }

    public ThuThuEntity(String khanhnqph27525CP17315maTT, String khanhnqph27525CP17315hoTen, String khanhnqph27525CP17315matKhau) {
        this.khanhnqph27525CP17315maTT = khanhnqph27525CP17315maTT;
        this.khanhnqph27525CP17315hoTen = khanhnqph27525CP17315hoTen;
        this.khanhnqph27525CP17315matKhau = khanhnqph27525CP17315matKhau;
    }

    public int getKhanhnqph27525CP17315idthuthu() {
        return khanhnqph27525CP17315idthuthu;
    }

    public void setKhanhnqph27525CP17315idthuthu(int khanhnqph27525CP17315idthuthu) {
        this.khanhnqph27525CP17315idthuthu = khanhnqph27525CP17315idthuthu;
    }

    public String getKhanhnqph27525CP17315maTT() {
        return khanhnqph27525CP17315maTT;
    }

    public void setKhanhnqph27525CP17315maTT(String khanhnqph27525CP17315maTT) {
        this.khanhnqph27525CP17315maTT = khanhnqph27525CP17315maTT;
    }

    public String getKhanhnqph27525CP17315hoTen() {
        return khanhnqph27525CP17315hoTen;
    }

    public void setKhanhnqph27525CP17315hoTen(String khanhnqph27525CP17315hoTen) {
        this.khanhnqph27525CP17315hoTen = khanhnqph27525CP17315hoTen;
    }

    public String getKhanhnqph27525CP17315matKhau() {
        return khanhnqph27525CP17315matKhau;
    }

    public void setKhanhnqph27525CP17315matKhau(String khanhnqph27525CP17315matKhau) {
        this.khanhnqph27525CP17315matKhau = khanhnqph27525CP17315matKhau;
    }

    public int getKhanhnqph27525CP17315imgDelete() {
        return khanhnqph27525CP17315imgDelete;
    }

    public void setKhanhnqph27525CP17315imgDelete(int khanhnqph27525CP17315imgDelete) {
        this.khanhnqph27525CP17315imgDelete = khanhnqph27525CP17315imgDelete;
    }
}
