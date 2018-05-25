package abbie.example.com.yorkshirerestaurants.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Rating implements Parcelable {

    @SerializedName("aggregate_rating")
    public String aggregate_rating;
    @SerializedName("rating_text")
    public String rating_text;
    @SerializedName("rating_color")
    public String rating_color;
    @SerializedName("votes")
    public String votes;

    protected Rating(Parcel in) {
        aggregate_rating = in.readString();
        rating_text = in.readString();
        rating_color = in.readString();
        votes = in.readString();
    }

    public static final Creator<Rating> CREATOR = new Creator<Rating>() {
        @Override
        public Rating createFromParcel(Parcel in) {
            return new Rating(in);
        }

        @Override
        public Rating[] newArray(int size) {
            return new Rating[size];
        }
    };

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

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getRating_color() {
        return rating_color;
    }

    public void setRating_color(String rating_color) {
        this.rating_color = rating_color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(aggregate_rating);
        parcel.writeString(rating_text);
        parcel.writeString(rating_color);
        parcel.writeString(votes);
    }
}
