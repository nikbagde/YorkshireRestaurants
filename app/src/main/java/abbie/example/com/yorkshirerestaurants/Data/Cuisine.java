package abbie.example.com.yorkshirerestaurants.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "cuisineTable")
public class Cuisine{

    @PrimaryKey(autoGenerate = false)
    @SerializedName("cuisine_id")
    private int cuisine_id;
    @SerializedName("cuisine_name")
    private String cuisine_name;

    public int getCuisine_id() {
        return cuisine_id;
    }

    public void setCuisine_id(int cuisine_id) {
        this.cuisine_id = cuisine_id;
    }

    public String getCuisine_name() {
        return cuisine_name;
    }

    public void setCuisine_name(String cuisine_name) {
        this.cuisine_name = cuisine_name;
    }

    public Cuisine(int cuisine_id, String cuisine_name) {
        this.cuisine_id = cuisine_id;
        this.cuisine_name = cuisine_name;
    }
}