package abbie.example.com.yorkshirerestaurants.Database.DatabaseModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "restaurantTable")
public class DataDBModel {

    @PrimaryKey(autoGenerate = false)
    public String id;
    public String address;
    public String locality;
    public String city;
    public String lat;
    public String longt;
    public String zipcode;
    public String aggregate_rating;
    public String rating_text;
    public String name;
    public String url;
    public int price_range;
    public String photos_url;
    public String menu_url;
    public int online_delivery;
    public String cuisines;

    public DataDBModel(String id, String address, String locality, String city, String lat,
                       String longt, String zipcode, String aggregate_rating, String rating_text,
                       String name, String url, int price_range, String photos_url, String menu_url,
                       int online_delivery, String cuisines) {
        this.id = id;
        this.address = address;
        this.locality = locality;
        this.city = city;
        this.lat = lat;
        this.longt = longt;
        this.zipcode = zipcode;
        this.aggregate_rating = aggregate_rating;
        this.rating_text = rating_text;
        this.name = name;
        this.url = url;
        this.price_range = price_range;
        this.photos_url = photos_url;
        this.menu_url = menu_url;
        this.online_delivery = online_delivery;
        this.cuisines = cuisines;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongt() {
        return longt;
    }

    public void setLongt(String longt) {
        this.longt = longt;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAggregate_rating() {
        return aggregate_rating;
    }

    public void setAggregate_rating(String aggregate_rating) {
        this.aggregate_rating = aggregate_rating;
    }

    public String getRating_text() {
        return rating_text;
    }

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
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

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }
}
