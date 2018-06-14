package abbie.example.com.yorkshirerestaurants;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import abbie.example.com.yorkshirerestaurants.API.ZomatoAPI;
import abbie.example.com.yorkshirerestaurants.Adapters.RestaurantAdapter;
import abbie.example.com.yorkshirerestaurants.Adapters.RestaurantJsonAdapter;
import abbie.example.com.yorkshirerestaurants.Data.Location;
import abbie.example.com.yorkshirerestaurants.Data.Rating;
import abbie.example.com.yorkshirerestaurants.Data.Restaurant;
import abbie.example.com.yorkshirerestaurants.Data.Restaurants;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
        setContentView(R.layout.activity_restaurants_list);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            cuisineID = extras.getInt("CUISINE_ID");

        }

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Restaurant.class, new RestaurantJsonAdapter())
                .create();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(builder.build())
                .build();

        service = retrofit.create(ZomatoAPI.ZomatoApiCalls.class);

        fetchRestaurants();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        restaurantAdapter = new RestaurantAdapter(this, this);
        recyclerView.setAdapter(restaurantAdapter);
    }

    public void fetchRestaurants() {
        service.getRestaurants("332", "city", "1", "20", "53.382882", "-1.470300", "rating", cuisineID, "asc")
                .enqueue(new Callback<Restaurants>() {
                    @Override
                    public void onResponse(Call<Restaurants> call, Response<Restaurants> response) {
                        List<Restaurant> restaurants = response.body().getRestaurantList();
                        restaurantAdapter.setRestaurantList(restaurants);
                    }

                    @Override
                    public void onFailure(Call<Restaurants> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorites_menu:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    setEnterExitTransition(new Intent(RestaurantsListActivity.this, RestaurantsActivity.class));
                }
                startActivity(new Intent(this, RestaurantsActivity.class));
                return true;

            case R.id.logout:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent intent = new Intent(RestaurantsListActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setEnterExitTransition(Intent intent) {
        getWindow().setExitTransition(new Fade().setDuration(1000));
        getWindow().setReenterTransition(new Fade().setDuration(1000));
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(RestaurantsListActivity.this).toBundle());
    }

    @Override
    public void onRestaurantItemClick(Restaurant restaurant) {
        String id = restaurant.getId();
        Location location = restaurant.getLocation();
        String menu_url = restaurant.getMenu_url();
        String restaurant_name = restaurant.getName();
        int has_online_delivery = restaurant.getOnline_delivery();
        String photo_url = restaurant.getPhotos_url();
        String web_url = restaurant.getUrl();
        Rating rating = restaurant.getUserRatingList();

        String id_TAG = "ID : ";
        String location_TAG = "Location : ";
        String menu_url_TAG = "Menu URL : ";
        String name_TAG = "Restaurants Name : ";
        String delivery_TAG = "Has online delivery : ";
        String photo_url_TAG = "Photo URL : ";
        String web_url_TAG = "Web URL : ";
        String rating_TAG = "Rating : ";

        // List<Location> locations;
        // locations = restaurant.getLocation());

        //  List<Rating> ratings;
        //  ratings = restaurant.getUserRatingList());

        Intent intent = new Intent(RestaurantsListActivity.this, RestaurantsActivity.class);
        intent.putExtra(id_TAG, id);
        intent.putExtra(menu_url_TAG, menu_url);
        //intent.putParcelableArrayListExtra(location_TAG, (ArrayList<? extends Parcelable>) locations);
        intent.putExtra(name_TAG, restaurant_name);
        intent.putExtra(delivery_TAG, has_online_delivery);
        intent.putExtra(photo_url_TAG, photo_url);
        intent.putExtra(web_url_TAG, web_url);
        // intent.putParcelableArrayListExtra(rating_TAG, (ArrayList<? extends Parcelable>) ratings);

        startActivity(intent);
    }
}