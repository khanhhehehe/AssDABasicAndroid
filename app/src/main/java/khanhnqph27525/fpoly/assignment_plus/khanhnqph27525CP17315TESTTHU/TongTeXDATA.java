package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315TESTTHU;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {TongTexDTO.class},version = 1)
public abstract class TongTeXDATA extends RoomDatabase {
    private static final String DATABASE_TONG = "db_objTongTeX";
    private static TongTeXDATA instance;

    public static synchronized TongTeXDATA getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),TongTeXDATA.class,DATABASE_TONG).allowMainThreadQueries().build();
        }
        return instance;
    }
}
