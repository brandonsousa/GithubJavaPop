package com.brandonsousa.app.model;

/*
 * @created at 21/10/2020 - 19:12
 * @project App
 * @author brand
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({"total_count", "incomplete_results"})
public class Results {
    private List<Repository> items;

    public Results() {
    }

    public List<Repository> getItems() {
        return items;
    }

    public void setItems(List<Repository> items) {
        this.items = items;
    }
}
