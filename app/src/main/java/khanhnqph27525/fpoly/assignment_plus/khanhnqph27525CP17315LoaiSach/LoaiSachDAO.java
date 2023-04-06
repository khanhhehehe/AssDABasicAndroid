package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LoaiSachDAO {
    @Insert
    void insertObjLoaiSach(LoaiSachEntity loaiSach);

    @Query("SELECT * FROM tb_loaiSach")
    List<LoaiSachEntity> getListObjLS();

    @Query("DELETE FROM tb_loaiSach where khanhnqph27525CP17315idloaisach= :objidLS")
    abstract int getObjidLS(int objidLS);

    @Update
    void updateObjLS(LoaiSachEntity loaiSach);
}
