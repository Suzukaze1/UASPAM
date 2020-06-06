package com.alvinmd.uaspam.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alvinmd.uaspam.R;
import com.alvinmd.uaspam.activity.DetailActivity;
import com.alvinmd.uaspam.activity.MainActivity;
import com.alvinmd.uaspam.model.Result;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RVMovies extends RecyclerView.Adapter<RVMovies.MyViewHolder> {

    private Context mContext;
    private List<Result> mData ;

    public RVMovies(Context mContext, List<Result> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RVMovies.MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_film, parent, false);

        final RVMovies.MyViewHolder viewHolder = new RVMovies.MyViewHolder(view);
        viewHolder.relativeLayoutDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(parent.getContext(), DetailActivity.class);
                Result result = new Result();
                result.setBackdropPath(mData.get(viewHolder.getAdapterPosition()).getBackdropPath());
                result.setPosterPath(mData.get(viewHolder.getAdapterPosition()).getPosterPath());
                result.setOriginalTitle(mData.get(viewHolder.getAdapterPosition()).getOriginalTitle());
                result.setReleaseDate(mData.get(viewHolder.getAdapterPosition()).getReleaseDate());
                result.setPopularity(mData.get(viewHolder.getAdapterPosition()).getPopularity());
                result.setVoteCount(mData.get(viewHolder.getAdapterPosition()).getVoteCount());
                result.setOverview(mData.get(viewHolder.getAdapterPosition()).getOverview());
                result.setPosterPath(mData.get(viewHolder.getAdapterPosition()).getPosterPath());
                result.setBackdropPath(mData.get(viewHolder.getAdapterPosition()).getBackdropPath());
                i.putExtra(DetailActivity.EXTRA_MOVIE, result);
                parent.getContext().startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RVMovies.MyViewHolder holder, int position) {
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w185" +mData.get(position).getPosterPath())
                .into(holder.image);

        holder.tvTitle.setText(mData.get(position).getTitle());
        holder.tvDescription.setText(mData.get(position).getOverview());
        holder.tvReleaseDate.setText(mData.get(position).getReleaseDate());
        holder.tvPopularity.setText(String.valueOf(mData.get(position).getPopularity()));
        holder.tvVoteCount.setText(String.valueOf(mData.get(position).getVoteCount()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription, tvReleaseDate, tvPopularity,tvVoteCount;
        ImageView image;
        RelativeLayout relativeLayoutDetail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            image = itemView.findViewById(R.id.thumbnail01);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            tvPopularity = itemView.findViewById(R.id.tvPopularity);
            tvVoteCount = itemView.findViewById(R.id.tvVoteCount);
            relativeLayoutDetail = itemView.findViewById(R.id.relativeDetail);
        }

    }
}
