package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315SachMuonNhieu;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_thongKe")
public class ThongKe {
    @PrimaryKey
    @NonNull
    private String khanhnqph27525CP17315tenSach;
    private int khanhnqph27525CP17315soLuong;

    public ThongKe() {
    }

    public ThongKe(@NonNull String khanhnqph27525CP17315tenSach, int khanhnqph27525CP17315soLuong) {
        this.khanhnqph27525CP17315tenSach = khanhnqph27525CP17315tenSach;
        this.khanhnqph27525CP17315soLuong = khanhnqph27525CP17315soLuong;
    }

    @NonNull
    public String getKhanhnqph27525CP17315tenSach() {
        return khanhnqph27525CP17315tenSach;
    }

    public void setKhanhnqph27525CP17315tenSach(@NonNull String khanhnqph27525CP17315tenSach) {
        this.khanhnqph27525CP17315tenSach = khanhnqph27525CP17315tenSach;
    }

    public int getKhanhnqph27525CP17315soLuong() {
        return khanhnqph27525CP17315soLuong;
    }

    public void setKhanhnqph27525CP17315soLuong(int khanhnqph27525CP17315soLuong) {
        this.khanhnqph27525CP17315soLuong = khanhnqph27525CP17315soLuong;
    }
}
