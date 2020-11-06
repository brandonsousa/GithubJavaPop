package com.brandonsousa.app.config;

/*
 * @created at 21/10/2020 - 19:46
 * @project App
 * @author brand
 */

import com.brandonsousa.app.network.Repositories;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {
    private final String BASE_URL = "https://api.github.com/";

    private Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder().addConverterFactory(JacksonConverterFactory.create()).baseUrl(BASE_URL).build();
    }

    public Repositories repositories() {
        return this.retrofit.create(Repositories.class);
    }
}
