package com.alvinmd.uaspam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alvinmd.uaspam.R;
import com.alvinmd.uaspam.model.Result;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "string_extra";
    TextView tvTitle,tvReleaseDate,tvPopularity,tvVoteCount,tvGenre,tvDescription;
    ImageView ivPosterPath,ivBackdropPath;
    String title,releaseDate,popularity,voteCount,description,backdropPath,posterPath;
    Result result;
    FloatingActionButton fabBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvTitle_Detail);
        tvReleaseDate = findViewById(R.id.tvReleaseDateDetail);
        tvPopularity = findViewById(R.id.tvPopularityDetail);
        tvVoteCount = findViewById(R.id.tvVoteCountDetail);
        tvGenre = findViewById(R.id.tvGenreDetail);
        tvDescription = findViewById(R.id.tvDescriptionDetail);
        ivPosterPath = findViewById(R.id.iv_poster_path_detail);
        ivBackdropPath = findViewById(R.id.iv_backdrop_path);
        fabBack = findViewById(R.id.fabBack);

        result = getIntent().getParcelableExtra(EXTRA_MOVIE);

        assert result != null;
        title = result.getOriginalTitle();
        releaseDate = result.getReleaseDate();
        popularity = String.valueOf(result.getPopularity());
        voteCount = String.valueOf(result.getVoteCount());
        description = result.getOverview();
        backdropPath = result.getBackdropPath();
        posterPath = result.getPosterPath();

        String url_backdrop = "https://image.tmdb.org/t/p/original";
        String url_poster = "https://image.tmdb.org/t/p/w185";

        Glide.with(getApplicationContext())
                .load(url_backdrop+backdropPath)
                .into(ivBackdropPath);

        Glide.with(getApplicationContext())
                .load(url_poster + posterPath)
                .into(ivPosterPath);

        tvTitle.setText(title);
        tvReleaseDate.setText(releaseDate);
        tvPopularity.setText(popularity);
        tvVoteCount.setText(voteCount);
        tvDescription.setText(description);

        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (android.R.id.home == item.getItemId()){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
