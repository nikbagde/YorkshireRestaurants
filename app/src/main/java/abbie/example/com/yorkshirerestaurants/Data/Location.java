package abbie.example.com.yorkshirerestaurants.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Location implements Parcelable {

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

    protected Location(Parcel in) {
        address = in.readString();
        locality = in.readString();
        city = in.readString();
        city_id = in.readString();
        lat = in.readString();
        longt = in.readString();
        zipcode = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(locality);
        dest.writeString(city);
        dest.writeString(city_id);
        dest.writeString(lat);
        dest.writeString(longt);
        dest.writeString(zipcode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

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
