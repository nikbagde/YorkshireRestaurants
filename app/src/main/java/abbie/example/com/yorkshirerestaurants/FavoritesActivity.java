package abbie.example.com.yorkshirerestaurants;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favorites_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_menu:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    setEnterExitTransition(new Intent(FavoritesActivity.this, CuisineActivity.class));
                }
                startActivity(new Intent(this, CuisineActivity.class));
                return true;
            case R.id.logout:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent intent = new Intent(FavoritesActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setEnterExitTransition(Intent intent){
        getWindow().setExitTransition(new Fade().setDuration(1000));
        getWindow().setReenterTransition(new Fade().setDuration(1000));
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(FavoritesActivity.this).toBundle());
    }
}