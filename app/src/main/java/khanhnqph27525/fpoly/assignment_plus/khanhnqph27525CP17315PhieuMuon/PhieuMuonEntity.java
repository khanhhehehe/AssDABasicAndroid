package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_phieuMuon")
public class PhieuMuonEntity {
    @PrimaryKey(autoGenerate = true)
    private int khanhnqph27525CP17315idphieuMuon;
    private int khanhnqph27525CP17315maPM;
    private String khanhnqph27525CP17315tenTV;
    private String khanhnqph27525CP17315tenSach;
    private int khanhnqph27525CP17315tienThue;
    private int khanhnqph27525CP17315traSach;
    private String khanhnqph27525CP17315ngay;
    private int khanhnqph27525CP17315imgDelete;

    public PhieuMuonEntity() {
    }

    public PhieuMuonEntity(int khanhnqph27525CP17315maPM, String khanhnqph27525CP17315tenTV, String khanhnqph27525CP17315tenSach, int khanhnqph27525CP17315tienThue, int khanhnqph27525CP17315traSach, String khanhnqph27525CP17315ngay) {
        this.khanhnqph27525CP17315maPM = khanhnqph27525CP17315maPM;
        this.khanhnqph27525CP17315tenTV = khanhnqph27525CP17315tenTV;
        this.khanhnqph27525CP17315tenSach = khanhnqph27525CP17315tenSach;
        this.khanhnqph27525CP17315tienThue = khanhnqph27525CP17315tienThue;
        this.khanhnqph27525CP17315traSach = khanhnqph27525CP17315traSach;
        this.khanhnqph27525CP17315ngay = khanhnqph27525CP17315ngay;
    }

    public int getKhanhnqph27525CP17315idphieuMuon() {
        return khanhnqph27525CP17315idphieuMuon;
    }

    public void setKhanhnqph27525CP17315idphieuMuon(int khanhnqph27525CP17315idphieuMuon) {
        this.khanhnqph27525CP17315idphieuMuon = khanhnqph27525CP17315idphieuMuon;
    }

    public int getKhanhnqph27525CP17315maPM() {
        return khanhnqph27525CP17315maPM;
    }

    public void setKhanhnqph27525CP17315maPM(int khanhnqph27525CP17315maPM) {
        this.khanhnqph27525CP17315maPM = khanhnqph27525CP17315maPM;
    }

    public String getKhanhnqph27525CP17315tenTV() {
        return khanhnqph27525CP17315tenTV;
    }

    public void setKhanhnqph27525CP17315tenTV(String khanhnqph27525CP17315tenTV) {
        this.khanhnqph27525CP17315tenTV = khanhnqph27525CP17315tenTV;
    }

    public String getKhanhnqph27525CP17315tenSach() {
        return khanhnqph27525CP17315tenSach;
    }

    public void setKhanhnqph27525CP17315tenSach(String khanhnqph27525CP17315tenSach) {
        this.khanhnqph27525CP17315tenSach = khanhnqph27525CP17315tenSach;
    }

    public int getKhanhnqph27525CP17315tienThue() {
        return khanhnqph27525CP17315tienThue;
    }

    public void setKhanhnqph27525CP17315tienThue(int khanhnqph27525CP17315tienThue) {
        this.khanhnqph27525CP17315tienThue = khanhnqph27525CP17315tienThue;
    }

    public int getKhanhnqph27525CP17315traSach() {
        return khanhnqph27525CP17315traSach;
    }

    public void setKhanhnqph27525CP17315traSach(int khanhnqph27525CP17315traSach) {
        this.khanhnqph27525CP17315traSach = khanhnqph27525CP17315traSach;
    }

    public String getKhanhnqph27525CP17315ngay() {
        return khanhnqph27525CP17315ngay;
    }

    public void setKhanhnqph27525CP17315ngay(String khanhnqph27525CP17315ngay) {
        this.khanhnqph27525CP17315ngay = khanhnqph27525CP17315ngay;
    }

    public int getKhanhnqph27525CP17315imgDelete() {
        return khanhnqph27525CP17315imgDelete;
    }

    public void setKhanhnqph27525CP17315imgDelete(int khanhnqph27525CP17315imgDelete) {
        this.khanhnqph27525CP17315imgDelete = khanhnqph27525CP17315imgDelete;
    }
}
