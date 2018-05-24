package abbie.example.com.yorkshirerestaurants.Data;

import com.google.gson.annotations.SerializedName;

public class Rating{

    @SerializedName("aggregate_rating")
    public int aggregate_rating;
    @SerializedName("rating_text")
    public int rating_text;
    @SerializedName("rating_color")
    public int rating_color;
    @SerializedName("votes")
    public int votes;

    public int getAggregate_rating() {
        return aggregate_rating;
    }

    public void setAggregate_rating(int aggregate_rating) {
        this.aggregate_rating = aggregate_rating;
    }

    public int getRating_text() {
        return rating_text;
    }

    public void setRating_text(int rating_text) {
        this.rating_text = rating_text;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getRating_color() {
        return rating_color;
    }

    public void setRating_color(int rating_color) {
        this.rating_color = rating_color;
    }
}
