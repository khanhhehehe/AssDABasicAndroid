package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PhieuMuonEntity.class},version = 1)
public abstract class PhieuMuonDATA extends RoomDatabase {
    private static final String DATABASE_PM = "db_objPM";
    private static PhieuMuonDATA instance;

    public static synchronized PhieuMuonDATA getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),PhieuMuonDATA.class,DATABASE_PM).allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract PhieuMuonDAO phieuMuonDAO();
}
