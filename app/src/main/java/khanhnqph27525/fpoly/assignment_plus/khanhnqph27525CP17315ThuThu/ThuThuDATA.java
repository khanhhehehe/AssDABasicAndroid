package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThuThu;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ThuThuEntity.class},version = 1)
public abstract class ThuThuDATA extends RoomDatabase {
    private static final String DATABASE_TT = "db_objTT";
    private static ThuThuDATA instance;
    public static synchronized ThuThuDATA getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),ThuThuDATA.class,DATABASE_TT).allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract ThuThuDAO thuThuDAO();
}
