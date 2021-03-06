package abbie.example.com.yorkshirerestaurants;

import android.app.ActivityOptions;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import abbie.example.com.yorkshirerestaurants.API.ZomatoAPI;
import abbie.example.com.yorkshirerestaurants.Adapters.CuisineAdapter;
import abbie.example.com.yorkshirerestaurants.Adapters.CuisineJsonAdapter;
import abbie.example.com.yorkshirerestaurants.Data.Cuisine;
import abbie.example.com.yorkshirerestaurants.Data.Cuisines;
import abbie.example.com.yorkshirerestaurants.Database.DatabaseModels.DataDBModel;
import abbie.example.com.yorkshirerestaurants.Database.MainViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CuisineActivity extends AppCompatActivity implements CuisineAdapter.CuisineItemClick {

    @BindView(R.id.adView)
    AdView mAdView;
    @BindView(R.id.cuisine_RV)
    RecyclerView recyclerView;

    private ZomatoAPI.ZomatoApiCalls service;
    private CuisineAdapter cuisineAdapter;
    private String TAG = "CUISINE_ID";
    private String BASE_URL = "https://developers.zomato.com/";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);
        ButterKnife.bind(this);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Cuisine.class, new CuisineJsonAdapter())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(ZomatoAPI.ZomatoApiCalls.class);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        cuisineAdapter = new CuisineAdapter(this, this);
        recyclerView.setAdapter(cuisineAdapter);

        fetchCuisines();

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    @Override
    protected void onPause() {
        super.onPause();
        setupViewModel();
    }

    private void setupViewModel() {
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getData().observe(this, new Observer<List<DataDBModel>>() {
            @Override
            public void onChanged(@Nullable List<DataDBModel> restaurantEntries) {
                Log.d(TAG, " " + restaurantEntries.size());

            }
        });
    }

    public void fetchCuisines() {
        service.getCuisineId("332", "53.382882", "-1.470300")
                .enqueue(new Callback<Cuisines>() {
                    @Override
                    public void onResponse(Call<Cuisines> call, Response<Cuisines> response) {
                        List<Cuisine> cuisines = response.body().getCuisinesList();
                        cuisineAdapter.setCuisineList(cuisines);
                    }

                    @Override
                    public void onFailure(Call<Cuisines> call, Throwable t) {
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
                    setEnterExitTransition(new Intent(CuisineActivity.this, FavoritesActivity.class));
                }
                startActivity(new Intent(this, FavoritesActivity.class));
                return true;
            case R.id.logout:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent intent = new Intent(CuisineActivity.this, MainActivity.class);
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
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(CuisineActivity.this).toBundle());
    }

    @Override
    public void onCuisineItemClick(Cuisine cuisines) {
        int id = cuisines.getCuisine_id();

        Intent intent = new Intent(CuisineActivity.this, RestaurantsListActivity.class);
        intent.putExtra(TAG, id);
        startActivity(intent);
    }
}

