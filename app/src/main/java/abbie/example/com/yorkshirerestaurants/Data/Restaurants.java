package abbie.example.com.yorkshirerestaurants.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restaurants {

    @SerializedName("restaurants")
    public List<Restaurant> restaurantList;

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public Restaurants(List<Restaurant> restaurantList) {
        this.restaurantList = getRestaurantList();
    }
}