package abbie.example.com.yorkshirerestaurants.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cuisines implements Parcelable {

    @SerializedName("cuisines")
    public List<Cuisines> cuisinesList;


    protected Cuisines(Parcel in) {
        cuisinesList = in.createTypedArrayList(Cuisines.CREATOR);
    }

    public static final Creator<Cuisines> CREATOR = new Creator<Cuisines>() {
        @Override
        public Cuisines createFromParcel(Parcel in) {
            return new Cuisines(in);
        }

        @Override
        public Cuisines[] newArray(int size) {
            return new Cuisines[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(cuisinesList);
    }

    public List<Cuisines> getCuisinesList() {
        return cuisinesList;
    }

    public void setCuisinesList(List<Cuisines> cuisinesList) {
        this.cuisinesList = cuisinesList;
    }
}