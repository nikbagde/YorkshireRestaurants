package abbie.example.com.yorkshirerestaurants;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import java.util.List;
import abbie.example.com.yorkshirerestaurants.API.ZomatoAPI;
import abbie.example.com.yorkshirerestaurants.Adapters.CuisineAdapter;
import abbie.example.com.yorkshirerestaurants.Data.Cuisines;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CuisineActivity extends AppCompatActivity implements CuisineAdapter.CuisineItemClick {

    @BindView(R.id.adView)
    AdView mAdView;
    @BindView(R.id.cuisine_RV)
    RecyclerView recyclerView;

    private ZomatoAPI.ZomatoApiCalls service;
    private CuisineAdapter cuisineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);
        ButterKnife.bind(this);


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://developers.zomato.com/")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        service = restAdapter.create(ZomatoAPI.ZomatoApiCalls.class);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        cuisineAdapter = new CuisineAdapter(this, this);
        recyclerView.setAdapter(cuisineAdapter);

        fetchCuisines();

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    public void fetchCuisines() {
       service.getCuisineId(new Callback<List<Cuisines>>() {
           @Override
           public void success(List<Cuisines> cuisines, Response response) {
               cuisineAdapter.setCuisineList(cuisines);
           }

           @Override
           public void failure(RetrofitError error) {
               error.printStackTrace();
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
                    setEnterExitTransition(new Intent(CuisineActivity.this, FavoritesActivity.class));
                }
                startActivity(new Intent(this, FavoritesActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setEnterExitTransition(Intent intent) {
        getWindow().setExitTransition(new Fade().setDuration(1000));
        getWindow().setReenterTransition(new Fade().setDuration(1000));
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(CuisineActivity.this).toBundle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCuisineItemClick(Cuisines cuisines) {
        Toast.makeText(getApplicationContext(), "clicked " + cuisines, Toast.LENGTH_LONG).show();
    }
}