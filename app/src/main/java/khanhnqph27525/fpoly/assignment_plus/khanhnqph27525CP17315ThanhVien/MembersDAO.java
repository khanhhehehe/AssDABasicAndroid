package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface MembersDAO {
    @Insert
    void insertObjmem(Members members);

    @Query("SELECT * FROM tb_thanhVien")
    List<Members> getListObjMEM();

    @Query("DELETE FROM tb_thanhVien where khanhnqph27525CP17315idthanhvien= :objidMEM")
    abstract int getObjidMEM(int objidMEM);

    @Update
    void updateObjMEM(Members members);
}
