package abbie.example.com.yorkshirerestaurants;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import abbie.example.com.yorkshirerestaurants.Data.Location;
import abbie.example.com.yorkshirerestaurants.Data.Rating;
import abbie.example.com.yorkshirerestaurants.Database.AppDatabase;
import abbie.example.com.yorkshirerestaurants.Database.AppExecutors;
import abbie.example.com.yorkshirerestaurants.Database.DataDbDAO;
import abbie.example.com.yorkshirerestaurants.Database.DatabaseModels.DataDBModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {

    private String menu_url;
    private String name;
    private int delivery;
    private String photo_url;
    private String web_url;
    private List<Rating> rating;
    private List<Location> location;

    DataDBModel dataDBModel;

    @BindView(R.id.address_tv_1)
    TextView address_line_1;
    @BindView(R.id.address_tv_2)
    TextView address_line_2;
    @BindView(R.id.address_tv_3)
    TextView address_line_3;
    @BindView(R.id.online_delivery_tv)
    TextView online_delivery_tv;
    @BindView(R.id.menu_url_icon)
    ImageView menu_url_iv;
    @BindView(R.id.web_link_icon)
    ImageView web_icon;
    @BindView(R.id.favorites_button)
    ImageView favorties_button;
    @BindView(R.id.restaurant_photo)
    ImageView restaurant_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            menu_url = extras.getString("Menu URL : ");
            name = extras.getString("Restaurants Name : ");
            delivery = extras.getInt("Has online delivery : ");
            photo_url = extras.getString("Photo URL : ");
            web_url = extras.getString("Web URL : ");

            //location = this.getIntent().getParcelableArrayListExtra("Location : ");
            //rating = this.getIntent().getParcelableArrayListExtra("Rating : ");
        }

        getSupportActionBar().setTitle(name);

        dataDBModel.setMenu_url(menu_url);
        dataDBModel.setName(name);
        dataDBModel.setOnline_delivery(delivery);
        dataDBModel.setPhotos_url(photo_url);
        dataDBModel.setUrl(web_url);

        //get location items and set address line 1,2,3
        //get rating list and add in recyclerview to scroll through them
        //implement maps and add location items (lat and long)
        //implement appbar for image, menu and three icons?

        favorties_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        AppDatabase.getInstance(RestaurantsActivity.this)
                                .restaurantsDAO()
                                .insertData(dataDBModel);

                    }
                });
            }
        });

        restaurant_photo.setImageURI(Uri.parse(photo_url));

        if (delivery == 0) {
            online_delivery_tv.setText(" " + R.string.not_available);
        } else if (delivery == 1) {
            online_delivery_tv.setText(" " + R.string.available);
        }

        web_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(web_url));
                startActivity(intent);
            }
        });

        menu_url_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(menu_url));
                startActivity(intent);
            }
        });
    }
}