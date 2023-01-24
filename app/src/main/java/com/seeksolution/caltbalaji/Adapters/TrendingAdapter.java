package com.seeksolution.caltbalaji.Adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.seeksolution.caltbalaji.Models.TrendingModel;
import com.seeksolution.caltbalaji.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.logging.LogRecord;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {
public Context context;
public ArrayList<TrendingModel> arrayList;

    public TrendingAdapter(Context context, ArrayList<TrendingModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mycustom_layout_trending,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final int i = position;
            holder.imageView.setVisibility(View.GONE);//original gone
            holder.shimmerFrameLayout.startShimmer();//start Shimmer
            holder.imageView.setVisibility(View.VISIBLE);//grey visible
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    holder.shimmerFrameLayout.setVisibility(View.GONE);
                    Picasso.get().load(Uri.parse(arrayList.get(i).getImageUrls())).into(holder.imageView);
                }
            },5000);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ShimmerFrameLayout shimmerFrameLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_trending_list);
            shimmerFrameLayout = itemView.findViewById(R.id.simmer);

        }
    }
}
