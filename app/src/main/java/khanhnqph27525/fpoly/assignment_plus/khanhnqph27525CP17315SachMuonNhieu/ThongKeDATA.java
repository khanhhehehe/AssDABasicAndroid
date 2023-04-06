package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315SachMuonNhieu;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {ThongKe.class},version = 1)
public abstract class ThongKeDATA extends RoomDatabase {
    private static final String DATABASE_TK = "db_objTK";
    private static ThongKeDATA instance;

    public static synchronized ThongKeDATA getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),ThongKeDATA.class,DATABASE_TK).allowMainThreadQueries().build();
        }
        return instance;
    }
}
