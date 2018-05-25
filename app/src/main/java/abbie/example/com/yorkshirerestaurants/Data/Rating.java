package abbie.example.com.yorkshirerestaurants.Data;

import com.google.gson.annotations.SerializedName;

public class Rating{

    @SerializedName("aggregate_rating")
    public String aggregate_rating;
    @SerializedName("rating_text")
    public String rating_text;
    @SerializedName("rating_color")
    public String rating_color;
    @SerializedName("votes")
    public String votes;

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
}
