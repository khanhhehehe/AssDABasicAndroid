package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315TESTTHU;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface T_EX_DAO {
    @Insert
    void insertObjTeX(DTO_T_EX dtoTEx);

    @Query("SELECT * FROM tb_sanPham")
    List<DTO_T_EX> getListObjSP();

    @Update
    void updateObjSP(DTO_T_EX dtoTEx);

    @Query("SELECT loaiSp, SUM(donGia) as giaTongSP FROM tb_sanPham group by loaiSp")
    List<TongTexDTO> loadAllSP();

    @Query("DELETE FROM tb_sanPham where idsanPham= :objidSP")
    abstract int getObjidSP(int objidSP);

    @Query("SELECT SUM(donGia) as doanhThu FROM tb_sanPham")
    public List<Integer> listSP();


}
