package abbie.example.com.yorkshirerestaurants.Data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("url")
    public String url;
    @SerializedName("cuisines")
    public String cuisines;
    @SerializedName("average_cost_for_two")
    public int avg_cost;
    @SerializedName("price_range")
    public int price_range;
    @SerializedName("photos_url")
    public String photos_url;
    @SerializedName("menu_url")
    public String menu_url;
    @SerializedName("has_online_delivery")
    public int online_delivery;

    public static class RestaurantResults {

        @SerializedName("restaurants")
        public List<RestaurantWrapper> results;

        @Override
        public String toString() {
            return "RestaurantResults{" + "results=" + results + '}';
        }
    }

    public static class RestaurantWrapper {
        public Restaurant restaurant;

        @Override
        public String toString() {
            return "RestaurantWrapper{" + "restaurant=" + restaurant + '}';
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}