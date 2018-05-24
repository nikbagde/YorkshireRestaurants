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
    public int lat;
    @SerializedName("longt")
    public int longt;
    @SerializedName("zipcode")
    public int zipcode;

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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

}
