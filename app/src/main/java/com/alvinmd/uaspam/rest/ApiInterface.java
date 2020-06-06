package com.alvinmd.uaspam.rest;

import com.alvinmd.uaspam.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/3/movie/{category}")
    Call<Response> getMovies(
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("/3/search/movie")
    Call<Response> getQuery(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("query") String query,
            @Query("page") int page
    );

    //https://api.themoviedb.org/3/movie/popular?api_key=1805007963a4760044640bde94121491&language=en-US&page=1

    //https://api.themoviedb.org/3/search/movie?api_key=1805007963a4760044640bde94121491&language=en-US&query=cara&page=1

}
