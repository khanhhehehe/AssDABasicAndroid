package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SachDAO {
    @Insert
    void insertObjSach(SachEntity sach);

    @Query("SELECT * FROM tb_sach")
    List<SachEntity> getListObjS();

    @Query("DELETE FROM tb_sach where khanhnqph27525CP17315idsach= :objidS")
    abstract int getObjidS(int objidS);

    @Query("select * from  tb_sach where khanhnqph27525CP17315tenSach= :objTS")
    List<SachEntity> getSach(String objTS);

    @Query("select * from  tb_sach where khanhnqph27525CP17315tacGia= :objTS")
    List<SachEntity> getSachMa(String objTS);

    @Update
    void updateObjS(SachEntity sach);
}
