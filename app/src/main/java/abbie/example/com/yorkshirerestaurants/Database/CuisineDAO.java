package abbie.example.com.yorkshirerestaurants.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import abbie.example.com.yorkshirerestaurants.Data.Cuisine;

/*@Dao
public interface CuisineDAO {

        @Query("SELECT * FROM cuisineTable")
        LiveData<List<Cuisine>> loadAllCuisines();

        @Insert
        void insertCuisine(Cuisine cuisineEntry);

        @Update(onConflict = OnConflictStrategy.REPLACE)
        void updateCuisine(Cuisine cuisineEntry);

        @Delete
        void deleteCuisine(Cuisine cuisineEntry);

        @Query("SELECT * FROM cuisineTable WHERE cuisine_id = :id")
        LiveData<Cuisine> loadCuisineById(int id);
}
*/