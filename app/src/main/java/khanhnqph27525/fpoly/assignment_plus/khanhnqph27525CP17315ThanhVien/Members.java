package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_thanhVien")
public class Members {
    @PrimaryKey(autoGenerate = true)
    private int khanhnqph27525CP17315idthanhvien;
    private int khanhnqph27525CP17315maTV;
    private String khanhnqph27525CP17315tenthanhvien;
    private String khanhnqph27525CP17315namsinh;
    private int khanhnqph27525CP17315imgDelete;

    public Members() {
    }

    public Members(int khanhnqph27525CP17315maTV, String khanhnqph27525CP17315tenthanhvien, String khanhnqph27525CP17315namsinh) {
        this.khanhnqph27525CP17315maTV = khanhnqph27525CP17315maTV;
        this.khanhnqph27525CP17315tenthanhvien = khanhnqph27525CP17315tenthanhvien;
        this.khanhnqph27525CP17315namsinh = khanhnqph27525CP17315namsinh;
    }

    public int getKhanhnqph27525CP17315idthanhvien() {
        return khanhnqph27525CP17315idthanhvien;
    }

    public void setKhanhnqph27525CP17315idthanhvien(int khanhnqph27525CP17315idthanhvien) {
        this.khanhnqph27525CP17315idthanhvien = khanhnqph27525CP17315idthanhvien;
    }

    public int getKhanhnqph27525CP17315maTV() {
        return khanhnqph27525CP17315maTV;
    }

    public void setKhanhnqph27525CP17315maTV(int khanhnqph27525CP17315maTV) {
        this.khanhnqph27525CP17315maTV = khanhnqph27525CP17315maTV;
    }

    public String getKhanhnqph27525CP17315tenthanhvien() {
        return khanhnqph27525CP17315tenthanhvien;
    }

    public void setKhanhnqph27525CP17315tenthanhvien(String khanhnqph27525CP17315tenthanhvien) {
        this.khanhnqph27525CP17315tenthanhvien = khanhnqph27525CP17315tenthanhvien;
    }

    public String getKhanhnqph27525CP17315namsinh() {
        return khanhnqph27525CP17315namsinh;
    }

    public void setKhanhnqph27525CP17315namsinh(String khanhnqph27525CP17315namsinh) {
        this.khanhnqph27525CP17315namsinh = khanhnqph27525CP17315namsinh;
    }

    public int getKhanhnqph27525CP17315imgDelete() {
        return khanhnqph27525CP17315imgDelete;
    }

    public void setKhanhnqph27525CP17315imgDelete(int khanhnqph27525CP17315imgDelete) {
        this.khanhnqph27525CP17315imgDelete = khanhnqph27525CP17315imgDelete;
    }
}
