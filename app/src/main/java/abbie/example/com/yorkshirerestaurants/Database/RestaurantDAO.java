package abbie.example.com.yorkshirerestaurants.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import abbie.example.com.yorkshirerestaurants.Data.Restaurant;

//@Dao
//public interface RestaurantDAO {

  //  @Query("SELECT * FROM restaurantTable")
  //  LiveData<List<Restaurant>> loadAllResaurants();

  //  @Insert
   // void insertResaurant(Restaurant RestaurantEntry);

   // @Update(onConflict = OnConflictStrategy.REPLACE)
  //  void updateResaurant(Restaurant resaurantEntry);

  //  @Delete
   // void deleteResaurant(Restaurant resaurantEntry);

   // @Query("SELECT * FROM restaurantTable WHERE id = :id")
   // LiveData<Restaurant> loadResaurantById(int id);
//}