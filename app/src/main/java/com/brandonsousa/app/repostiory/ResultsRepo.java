package com.brandonsousa.app.repostiory;

/*
 * @created at 22/10/2020 - 11:07
 * @project App
 * @author brand
 */

import androidx.lifecycle.MutableLiveData;

import com.brandonsousa.app.config.RetrofitConfig;
import com.brandonsousa.app.model.Results;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultsRepo {
    public MutableLiveData<Results> load() {
        final MutableLiveData<Results> results = new MutableLiveData<>();
        Call<Results> resultsCall = new RetrofitConfig().repositories().repos();
        resultsCall.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                results.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
            }
        });
        return results;
    }
}
