package com.example.bay.pagination;

import com.example.bay.pagination.models.Models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by BAY on 2/23/2017.
 */

public interface RestApi {


    @GET("movie?type=now")
    Call<Models> getDataResponse();

    @GET("movie")
    Call<Models> getDataNews (@Query("type") String type, @Query("page") int page);

}
