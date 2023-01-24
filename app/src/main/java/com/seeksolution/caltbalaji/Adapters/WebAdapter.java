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
import com.seeksolution.caltbalaji.Models.WebModel;
import com.seeksolution.caltbalaji.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WebAdapter extends RecyclerView.Adapter<WebAdapter.ViewHolder> {
    ArrayList<WebModel> webArrayList;
    Context context;

    public WebAdapter(Context context,ArrayList<WebModel> webArrayList ) {
        this.webArrayList = webArrayList;
        this.context = context;
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
        holder.webimage.setVisibility(View.GONE);//original gone
        holder.shimmerFrameLayout.startShimmer();//start Shimmer
        holder.webimage.setVisibility(View.VISIBLE);//grey visible
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                holder.shimmerFrameLayout.setVisibility(View.GONE);
                Picasso.get().load(Uri.parse(webArrayList.get(i).getWebImageUrls())).into(holder.webimage);
            }
        },5000);


    }

    @Override
    public int getItemCount() {
     return webArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

      public ImageView webimage;
        public ShimmerFrameLayout shimmerFrameLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           webimage=itemView.findViewById(R.id.iv_trending_list);
            shimmerFrameLayout = itemView.findViewById(R.id.simmer);
        }
    }
}
