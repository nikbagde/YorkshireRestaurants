package abbie.example.com.yorkshirerestaurants.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import abbie.example.com.yorkshirerestaurants.Data.Cuisine;
import abbie.example.com.yorkshirerestaurants.R;

public class CuisineAdapter extends RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder> {
    private List<Cuisine> cuisineList;
    private final Context mContext;
    private final CuisineItemClick listener;

    public CuisineAdapter(Context context, CuisineItemClick listener) {
        cuisineList = new ArrayList<>();
        mContext = context;
        this.listener = listener;
    }

    public void setCuisineList(List<Cuisine> cuisineList) {
        this.cuisineList.clear();
        this.cuisineList.addAll(cuisineList);
        notifyDataSetChanged();
    }

    @Override
    public CuisineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cuisine_item, parent, false);
        return new CuisineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CuisineViewHolder holder, int position) {
        Cuisine cuisine = cuisineList.get(position);

        String title = cuisine.getCuisine_name();
        holder.cuisineTitle.setText(title);
    }


    @Override
    public int getItemCount() {
        return cuisineList.size();
    }

    public class CuisineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView cuisineTitle;

        public CuisineViewHolder(View view) {
            super(view);
            cuisineTitle = view.findViewById(R.id.cuisine_title);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onCuisineItemClick(cuisineList.get(getAdapterPosition()));
        }
    }

    public interface CuisineItemClick{
        void onCuisineItemClick(Cuisine cuisines);
    }
}