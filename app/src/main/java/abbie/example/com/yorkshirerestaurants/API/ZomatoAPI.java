package abbie.example.com.yorkshirerestaurants.API;

import java.util.List;

import abbie.example.com.yorkshirerestaurants.Data.Cuisines;
import abbie.example.com.yorkshirerestaurants.Data.Restaurant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public class ZomatoAPI {
    public interface ZomatoApiCalls {

        @Headers("user-key: 81b9e0cc148b3fc6659c2b04a40fede5")
        @GET("api/v2.1/search")
        void getRestaurants(Callback<List<Restaurant>> callback,
                            @Query("entity_id") String entity_id,
                            @Query("entity_type") String entity_type,
                            @Query("start") String start,
                            @Query("count") String count,
                            @Query("lat") String lat,
                            @Query("lon") String lon,
                            @Query("sort") String sort,
                            @Query("cuisines") String cuisine,
                            @Query("order") String order);


        @Headers("user-key: 81b9e0cc148b3fc6659c2b04a40fede5")
        @GET("api/v2.1/cuisines")
        Call<List<Cuisines>> getCuisineId(@Query("city_id") String city_id,
                                          @Query("lat") String lat,
                                          @Query("lon") String lon);
    }
}


