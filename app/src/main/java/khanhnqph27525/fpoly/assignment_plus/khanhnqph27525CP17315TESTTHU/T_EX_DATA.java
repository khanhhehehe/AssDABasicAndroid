package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315TESTTHU;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DTO_T_EX.class},version = 1)
public abstract class T_EX_DATA extends RoomDatabase {
    private static final String DATABASE_T_EX = "db_objTEX";
    private static T_EX_DATA instance;

    public static synchronized T_EX_DATA getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),T_EX_DATA.class,DATABASE_T_EX).allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract T_EX_DAO tExDao();
}
