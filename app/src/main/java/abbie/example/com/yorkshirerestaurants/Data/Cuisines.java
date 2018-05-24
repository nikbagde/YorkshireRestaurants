package abbie.example.com.yorkshirerestaurants.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Cuisines implements Parcelable {

    @SerializedName("cuisine_id")
    private int cuisine_id;
    @SerializedName("cuisine_title")
    private String cuisine_title;
    @SerializedName("cuisine")
    private String cuisine;

    private Cuisines(Parcel in) {
        cuisine_id = in.readInt();
        cuisine_title = in.readString();
        cuisine = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cuisine_id);
        dest.writeString(cuisine_title);
        dest.writeString(cuisine);
    }

    public int getCuisine_id() {
        return cuisine_id;
    }

    public void setCuisine_id(int cuisine_id) {
        this.cuisine_id = cuisine_id;
    }

    public String getCuisine_title() {
        return cuisine_title;
    }

    public void setCuisine_title(String cuisine_title) {
        this.cuisine_title = cuisine_title;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public int describeContents() {
        return 0;
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

}
