package com.example.popularmovie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Movie> movieList ;
    private Context context ;

    public RecyclerAdapter(Context context, ArrayList<Movie> movies){
        this.context = context ;
        movieList = movies ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Movie movie = movieList.get(position);
        holder.rating.setText((movie.getRating().toString()));
        holder.title.setText(movie.getTitle());
        holder.overview.setText((movie.getOverview()));
        Picasso.get().load(movie.getPoster()).into(holder.image);

        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("title", movie.getTitle());
                bundle.putString("overview", movie.getOverview());
                bundle.putString("poster", movie.getPoster());
                bundle.putDouble("rating", movie.getRating());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return  movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image ;
        TextView title ;
        TextView rating ;
        TextView overview ;
        CardView cardView ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.movie_image);
            title = itemView.findViewById(R.id.movie_title);
            rating = itemView.findViewById(R.id.movie_rating);
            overview = itemView.findViewById(R.id.overview);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
