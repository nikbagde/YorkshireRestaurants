package abbie.example.com.yorkshirerestaurants.API;

import java.util.List;

import abbie.example.com.yorkshirerestaurants.Data.Cuisines;
import abbie.example.com.yorkshirerestaurants.Data.Restaurant;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

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
        @GET("api/v2.1/cuisines?city_id=332&lat=53.382882&lon=-1.470300")
        void getCuisineId(Callback<List<Cuisines>> callback);
    }
}


