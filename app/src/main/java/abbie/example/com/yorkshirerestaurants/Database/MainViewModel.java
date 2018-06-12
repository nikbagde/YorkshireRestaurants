package abbie.example.com.yorkshirerestaurants.Database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.util.List;

import abbie.example.com.yorkshirerestaurants.Database.DatabaseModels.DataDBModel;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<DataDBModel>> RestaurantData;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        RestaurantData = database.restaurantsDAO().loadAllData();
    }

    public LiveData<List<DataDBModel>> getData() {
        return RestaurantData;
    }
}