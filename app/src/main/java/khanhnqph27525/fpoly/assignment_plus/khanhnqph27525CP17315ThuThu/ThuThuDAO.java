package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThuThu;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ThuThuDAO {
    @Insert
    void insertObjTT(ThuThuEntity thuThu);

    @Query("SELECT * FROM tb_thuThu")
    List<ThuThuEntity> getListObjTT();

    @Query("DELETE FROM tb_thuThu where khanhnqph27525CP17315idthuthu= :objidTT")
    abstract int getObjidTT(int objidTT);

    @Update
    void updateObjTT(ThuThuEntity thuThu);
}
