package com.brandonsousa.app.viewmodel;

/*
 * @created at 22/10/2020 - 11:09
 * @project App
 * @author brand
 */

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.brandonsousa.app.model.Results;
import com.brandonsousa.app.repostiory.ResultsRepo;

public class ResultsVM extends LiveData {

    private ResultsRepo resultsRepo;
    private MutableLiveData<Results> resultsMutableLiveData;

    public ResultsVM() {
        resultsRepo = new ResultsRepo();
    }

    public LiveData<Results> load() {
        if (resultsMutableLiveData == null) {
            resultsMutableLiveData = resultsRepo.load();
        }
        return resultsMutableLiveData;
    }
}
