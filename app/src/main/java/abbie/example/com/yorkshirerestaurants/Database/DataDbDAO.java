package abbie.example.com.yorkshirerestaurants.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import abbie.example.com.yorkshirerestaurants.Database.DatabaseModels.DataDBModel;

@Dao
public interface DataDbDAO {
    @Query("SELECT * FROM restaurantsTable")
    LiveData<List<DataDBModel>> loadAllData();

    @Insert
    void insertData(DataDBModel dataDBModel);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateData(DataDBModel dataDBModel);

    @Delete
    void deleteData(DataDBModel dataDBModel);

    @Query("SELECT * FROM restaurantsTable WHERE id = :id")
    LiveData<DataDBModel> loadDataById(int id);
}