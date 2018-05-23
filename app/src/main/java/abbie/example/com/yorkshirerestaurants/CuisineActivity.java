package abbie.example.com.yorkshirerestaurants;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import abbie.example.com.yorkshirerestaurants.Data.Restaurant;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class CuisineActivity extends AppCompatActivity {

    @BindView(R.id.adView) AdView mAdView;
    @BindView(R.id.test_text) TextView textView;

    private ZomatoAPI.ZomatoApiCalls api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ZomatoAPI.ZomatoApiCalls.class);

        fetchRestaurants();

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    public void fetchRestaurants() {
        api.getRestaurantsBySearch("332", "city", "1", "20",
                                                "53.382882", "-1.470300", "rating", "asc")
        .enqueue(new Callback<Restaurant.RestaurantResults>() {
            @Override
            public void onResponse(@NonNull Call <Restaurant.RestaurantResults> call, @NonNull Response <Restaurant.RestaurantResults> response) {
              
            }

            @Override
            public void onFailure(@NonNull Call <Restaurant.RestaurantResults> call, Throwable t) {

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
                    setEnterExitTransition(new Intent(CuisineActivity.this,FavoritesActivity.class));
                }
                startActivity(new Intent(this, FavoritesActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setEnterExitTransition(Intent intent){
        getWindow().setExitTransition(new Fade().setDuration(1000));
        getWindow().setReenterTransition(new Fade().setDuration(1000));
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(CuisineActivity.this).toBundle());
    }
}
