package abbie.example.com.yorkshirerestaurants.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restaurant {

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("url")
    public String url;
    @SerializedName("location")
    public List<Location> locationList;
    @SerializedName("average_cost_for_two")
    public int avg_cost;
    @SerializedName("price_range")
    public int price_range;
    @SerializedName("photos_url")
    public String photos_url;
    @SerializedName("menu_url")
    public String menu_url;
    @SerializedName("user_rating")
    public List<Rating> userRatingList;
    @SerializedName("has_online_delivery")
    public int online_delivery;
    @SerializedName("cuisines")
    public String cuisines;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public int getAvg_cost() {
        return avg_cost;
    }

    public void setAvg_cost(int avg_cost) {
        this.avg_cost = avg_cost;
    }

    public int getPrice_range() {
        return price_range;
    }

    public void setPrice_range(int price_range) {
        this.price_range = price_range;
    }

    public String getPhotos_url() {
        return photos_url;
    }

    public void setPhotos_url(String photos_url) {
        this.photos_url = photos_url;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public int getOnline_delivery() {
        return online_delivery;
    }

    public void setOnline_delivery(int online_delivery) {
        this.online_delivery = online_delivery;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public List<Rating> getUserRatingList() {
        return userRatingList;
    }

    public void setUserRatingList(List<Rating> userRatingList) {
        this.userRatingList = userRatingList;
    }
}