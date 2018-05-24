package abbie.example.com.yorkshirerestaurants.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cuisines {

    @SerializedName("cuisine_id")
    public int cuisine_id;
    @SerializedName("cuisine_name")
    public String cuisine_name;

    public static class CuisineResults {

        @SerializedName("cuisines")
        public List<CuisineWrapper> results;

        @Override
        public String toString() {
            return "CuisineResults{" + "results=" + results + '}';
        }
    }

    public static class CuisineWrapper {
        public Cuisines cuisines;

        @Override
        public String toString() {
            return "CuisineWrapper{" + "cuisine=" + cuisines + '}';
        }
    }

    @Override
    public String toString() {
        return "Cuisines{" + "cuisine_id=" + cuisine_id + ", cuisine_name='" + cuisine_name + '\'' + '}';
    }
}
