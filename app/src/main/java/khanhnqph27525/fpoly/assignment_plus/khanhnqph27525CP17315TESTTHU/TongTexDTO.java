package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315TESTTHU;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_tongTeX")
public class TongTexDTO {
    @PrimaryKey
    @NonNull
    private String loaiSp;
    private int giaTongSP;

    public TongTexDTO() {
    }

    public TongTexDTO(String loaiSp, int giaTongSP) {
        this.loaiSp = loaiSp;
        this.giaTongSP = giaTongSP;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public int getGiaTongSP() {
        return giaTongSP;
    }

    public void setGiaTongSP(int giaTongSP) {
        this.giaTongSP = giaTongSP;
    }
}
