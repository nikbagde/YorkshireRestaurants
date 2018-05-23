package abbie.example.com.yorkshirerestaurants.API;

import abbie.example.com.yorkshirerestaurants.Data.Restaurant;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public class ZomatoAPI {
    public interface ZomatoApiCalls {

        @Headers("user-key: 81b9e0cc148b3fc6659c2b04a40fede5")
        @GET("api/v2.1/search")
        Observable<Restaurant.RestaurantResults> getRestaurants(@Query("entity_id") String entity_id,
                                                                @Query("entity_type") String entity_type,
                                                                @Query("start") String start,
                                                                @Query("count") String count,
                                                                @Query("lat") String lat,
                                                                @Query("lon") String lon,
                                                                @Query("sort") String sort,
                                                                      /*@Query("cuisines") String cuisine,*/
                                                                      @Query("order") String order);

       /* @Headers("user-key: 81b9e0cc148b3fc6659c2b04a40fede5")
        @GET("api/v2.1/cuisines")
        Observable<Restaurant.RestaurantResults> getCuisineId(@Query("city_id") String city_id);*/


    }
}


