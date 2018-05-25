package abbie.example.com.yorkshirerestaurants.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import abbie.example.com.yorkshirerestaurants.Data.Restaurant;
import abbie.example.com.yorkshirerestaurants.R;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private List<Restaurant> restaurantList;
    private final Context mContext;
    private final RestaurantAdapter.RestaurantItemClick listener;

    public RestaurantAdapter(Context context, RestaurantAdapter.RestaurantItemClick listener) {
        restaurantList = new ArrayList<>();
        mContext = context;
        this.listener = listener;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList.clear();
        this.restaurantList.addAll(restaurantList);
        notifyDataSetChanged();
    }

    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.restaurant_list_item, parent, false);
        return new RestaurantAdapter.RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantAdapter.RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);

        String restaurant_name = restaurant.getName();
        holder.restaurant_name.setText(restaurant_name);
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView restaurant_name;

        public RestaurantViewHolder(View view) {
            super(view);
            restaurant_name = view.findViewById(R.id.restaurant_name);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onRestaurantItemClick(restaurantList.get(getAdapterPosition()));
        }
    }

    public interface RestaurantItemClick{
        void onRestaurantItemClick(Restaurant restaurant);
    }
}

