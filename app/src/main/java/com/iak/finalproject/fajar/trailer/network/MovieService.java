package com.iak.finalproject.fajar.trailer.network;


import com.iak.finalproject.fajar.trailer.model.MovieResponse;
import com.iak.finalproject.fajar.trailer.utils.ServiceUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    /**
     * It will be generate URI :
     * http://api.themoviedb.org/3/movie/popular?api_key=<key>&page=<page>
     * @param apiKey
     * @return
     */
    @GET(ServiceUtils.POP_MOVIE_URL)
    Call<MovieResponse> getPopularMovie(
            @Query("api_key") String apiKey,
            @Query("page") int page);

    /**
     * It will be generate URI:
     * http://api.themoviedb.org/3/movie/top_rated?api_key=<key>&page=<page>
     * @param apiKey
     * @param page
     * @return
     */
    @GET(ServiceUtils.TOP_MOVIE_URL)
    Call<MovieResponse> getTopRatedMovie(
            @Query("api_key") String apiKey,
            @Query("page") int page);
}
