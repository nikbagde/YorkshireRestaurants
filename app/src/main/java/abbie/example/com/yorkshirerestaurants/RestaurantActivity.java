package abbie.example.com.yorkshirerestaurants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import abbie.example.com.yorkshirerestaurants.API.ZomatoAPI;
import abbie.example.com.yorkshirerestaurants.Data.Restaurant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantActivity extends AppCompatActivity {

    private ZomatoAPI.ZomatoApiCalls api;
    private Disposable disposable;
    private String cuisineID; //id fetched from pressing button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ZomatoAPI.ZomatoApiCalls.class);

        disposable = api.getRestaurants("332", "city", "1", "20",
                                            "53.382882", "-1.470300", "rating", cuisineID,"asc")
                .subscribeOn(Schedulers.io())
                .map(restaurantResults -> {
                    List<Restaurant> returnList = new ArrayList<>();
                    for (Restaurant.RestaurantWrapper result : restaurantResults.results) {
                        returnList.add(result.restaurant);
                    }
                    return returnList;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(() -> {
                })
                .subscribe(restaurants -> {
                    // list here based on cuisine ID
                }, Throwable::printStackTrace);
    }

    @Override
    protected void onDestroy() {
        if (disposable != null) disposable.dispose();
        super.onDestroy();
    }
}
