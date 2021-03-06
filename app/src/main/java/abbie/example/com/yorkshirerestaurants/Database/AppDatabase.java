package abbie.example.com.yorkshirerestaurants.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import abbie.example.com.yorkshirerestaurants.Data.Cuisine;
import abbie.example.com.yorkshirerestaurants.Data.Restaurant;
import abbie.example.com.yorkshirerestaurants.Database.DatabaseModels.DataDBModel;

@Database(entities = {DataDBModel.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "restaurantsDatabase";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract DataDbDAO restaurantsDAO();
}
