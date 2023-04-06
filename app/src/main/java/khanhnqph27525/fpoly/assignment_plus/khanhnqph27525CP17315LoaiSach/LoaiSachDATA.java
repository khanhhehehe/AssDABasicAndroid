package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {LoaiSachEntity.class},version = 1)
public abstract class LoaiSachDATA extends RoomDatabase {
    private static final String DATABASE_LS = "db_objLS";
    private static LoaiSachDATA instance;

    public static synchronized LoaiSachDATA getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),LoaiSachDATA.class,DATABASE_LS).allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract LoaiSachDAO loaiSachDAO();
}
