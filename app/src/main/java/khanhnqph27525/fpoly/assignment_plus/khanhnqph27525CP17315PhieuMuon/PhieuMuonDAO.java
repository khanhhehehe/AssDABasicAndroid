package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315SachMuonNhieu.ThongKe;


@Dao
public interface PhieuMuonDAO {
    @Insert
    void insertObjPhieuMuon(PhieuMuonEntity phieuMuon);

    @Query("SELECT * FROM tb_phieuMuon")
    List<PhieuMuonEntity> getListObjPM();

    @Query("SELECT khanhnqph27525CP17315tenSach, count(khanhnqph27525CP17315tenSach) as khanhnqph27525CP17315soLuong FROM tb_phieuMuon group by khanhnqph27525CP17315tenSach order by khanhnqph27525CP17315soLuong DESC LIMIT 10")
    List<ThongKe> loadAll();

    @Query("SELECT SUM(khanhnqph27525CP17315tienThue) as doanhThu FROM tb_phieuMuon WHERE khanhnqph27525CP17315ngay BETWEEN :dateStart AND :dateEnd")
    public List<Integer> listDT(String dateStart, String dateEnd);

    @Query("SELECT * FROM tb_phieuMuon where khanhnqph27525CP17315ngay BETWEEN :dateStart AND :dateEnd")
    public List<PhieuMuonEntity> listDT2(String dateStart, String dateEnd);



    @Query("DELETE FROM tb_phieuMuon where khanhnqph27525CP17315idphieuMuon= :objidPM")
    abstract int getObjidPM(int objidPM);

    @Update
    void updateObjPM(PhieuMuonEntity phieuMuon);
}
