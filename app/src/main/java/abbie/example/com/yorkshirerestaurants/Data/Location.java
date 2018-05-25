package abbie.example.com.yorkshirerestaurants.Data;

import com.google.gson.annotations.SerializedName;

public class Location{

    @SerializedName("address")
    public String address;
    @SerializedName("locality")
    public String locality;
    @SerializedName("city")
    public String city;
    @SerializedName("city_id")
    public String city_id;
    @SerializedName("lat")
    public String lat;
    @SerializedName("longt")
    public String longt;
    @SerializedName("zipcode")
    public String zipcode;

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

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
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

}
