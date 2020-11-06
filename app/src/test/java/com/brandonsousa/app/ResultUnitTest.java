package com.brandonsousa.app;

/*
 * @created at 22/10/2020 - 11:39
 * @project App
 * @author brand
 */

import com.brandonsousa.app.repostiory.ResultsRepo;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ResultUnitTest {
    @Test
    public void hasData() {
        ResultsRepo resultsRepo = new ResultsRepo();
        assertNotNull(resultsRepo.load());
    }
}
