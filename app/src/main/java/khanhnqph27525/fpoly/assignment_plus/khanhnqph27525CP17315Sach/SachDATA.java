package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SachEntity.class},version = 1)
public abstract class SachDATA extends RoomDatabase {
    private static final String DATABASE_S = "db_objS";
    private static SachDATA instance;

    public static synchronized SachDATA getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),SachDATA.class,DATABASE_S).allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract SachDAO sachDAO();
}
