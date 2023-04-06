package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Members.class},version = 1)
public abstract class MembersDATA extends RoomDatabase {
    private static final String DATABASE_MEM = "db_objMem";
    private static MembersDATA instance;

    public static synchronized MembersDATA getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),MembersDATA.class,DATABASE_MEM).allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract MembersDAO membersDAO();
}
