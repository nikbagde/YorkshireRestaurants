package abbie.example.com.yorkshirerestaurants.Data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("address")
    public String address;
    @SerializedName("city")
    public String city;
    @SerializedName("lat")
    public int lat;
    @SerializedName("longt")
    public int longt;
    @SerializedName("phone_number")
    public int phone_number;
    @SerializedName("avg_cost")
    public int avg_cost;
    @SerializedName("price_range")
    public int price_range;
    @SerializedName("img_url")
    public String img_url;
    @SerializedName("online_delivery")
    public int online_delivery;
    @SerializedName("rating")
    public int rating;

    public static class RestaurantResults {
        private List<Restaurant> results;
        public List<Restaurant> getResults() {
            return results;
        }
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLongt() {
        return longt;
    }

    public void setLongt(int longt) {
        this.longt = longt;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getOnline_delivery() {
        return online_delivery;
    }

    public void setOnline_delivery(int online_delivery) {
        this.online_delivery = online_delivery;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
