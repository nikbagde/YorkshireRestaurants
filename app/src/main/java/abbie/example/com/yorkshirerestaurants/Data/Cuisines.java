package abbie.example.com.yorkshirerestaurants.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cuisines {

    @SerializedName("cuisines")
    public List<Cuisine> cuisinesList;

    public Cuisines(List<Cuisine> cuisinesList) {
        this.cuisinesList = cuisinesList;
    }

    public List<Cuisine> getCuisinesList() {
        return cuisinesList;
    }

    public void setCuisinesList(List<Cuisine> cuisinesList) {
        this.cuisinesList = cuisinesList;
    }
}