package abbie.example.com.yorkshirerestaurants.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import abbie.example.com.yorkshirerestaurants.Data.Restaurant;
import abbie.example.com.yorkshirerestaurants.R;

public class CuisineAdapter extends RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder> {
        private List<Restaurant> restaurantList;
        private final Context mContext;

        public CuisineAdapter(Context context) {
            restaurantList = new ArrayList<>();
            mContext = context;
        }

        public void setRestaurantList(List<Restaurant> restaurantList) {
            this.restaurantList.clear();
            this.restaurantList.addAll(restaurantList);
            notifyDataSetChanged();
        }

        @Override
        public CuisineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.cuisine_item, parent, false);
            return new CuisineViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CuisineViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return restaurantList.size();
        }

        public class CuisineViewHolder extends RecyclerView.ViewHolder {

            public CuisineViewHolder(View view){
                super(view);

            }
        }
    }