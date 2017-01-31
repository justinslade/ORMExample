package za.co.justinslade.ormexample;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import za.co.justinslade.ormexample.entities.DaoMaster;
import za.co.justinslade.ormexample.entities.DaoSession;


public class MyApplication extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
