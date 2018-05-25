package abbie.example.com.yorkshirerestaurants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import abbie.example.com.yorkshirerestaurants.API.ZomatoAPI;
import abbie.example.com.yorkshirerestaurants.Adapters.RestaurantAdapter;
import abbie.example.com.yorkshirerestaurants.Adapters.RestaurantJsonAdapter;
import abbie.example.com.yorkshirerestaurants.Data.Restaurant;
import abbie.example.com.yorkshirerestaurants.Data.Restaurants;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestaurantsListActivity extends AppCompatActivity implements RestaurantAdapter.RestaurantItemClick {

    private ZomatoAPI.ZomatoApiCalls service;
    private int cuisineID;
    private RestaurantAdapter restaurantAdapter;

    @BindView(R.id.restaurant_RV)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            cuisineID = extras.getInt("CUISINE_ID");
        }

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Restaurant.class, new RestaurantJsonAdapter())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(ZomatoAPI.ZomatoApiCalls.class);

        fetchRestaurants();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        restaurantAdapter = new RestaurantAdapter(this, this);
        recyclerView.setAdapter(restaurantAdapter);

    }

    public void fetchRestaurants() {
        service.getRestaurants("332", "city", "1", "20",
                "53.382882", "-1.470300", "rating", cuisineID, "asc")
                .enqueue(new Callback<Restaurants>() {
                    @Override
                    public void onResponse(Call<Restaurants> call, Response<Restaurants> response) {
                        List<Restaurant> restaurants = response.body().getRestaurantList();
                        restaurantAdapter.setRestaurantList(restaurants);
                    }

                    @Override
                    public void onFailure(Call<Restaurants> call, Throwable t) {

                    }
                });
    }


    @Override
    public void onRestaurantItemClick(Restaurant restaurant) {


    }
}