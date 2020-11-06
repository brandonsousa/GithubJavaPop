package com.brandonsousa.app.network;

/*
 * @created at 21/10/2020 - 19:59
 * @project App
 * @author brand
 */

import com.brandonsousa.app.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Repositories {

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    Call<Results> repos();

    @GET("search/repositories?q=language:Java&sort={by}&page=1")
    Call<Results> sortBy(@Path("by") String by);

}
