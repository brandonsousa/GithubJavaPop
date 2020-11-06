package com.brandonsousa.app.view.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.brandonsousa.app.R;
import com.brandonsousa.app.model.Repository;
import com.brandonsousa.app.model.Results;
import com.brandonsousa.app.view.adapter.RepositoryAdapter;
import com.brandonsousa.app.viewmodel.ResultsVM;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar progressBar;
    private Switch swt_sort;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private RepositoryAdapter repositoryAdapter;

    private ResultsVM resultsVM;
    private Results results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        set();
        load();
    }

    private void set() {
        progressBar = findViewById(R.id.pb_main);
        recyclerView = findViewById(R.id.rv_main);
        swt_sort = findViewById(R.id.swt_sort_by);
        swt_sort.setOnClickListener(this);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        resultsVM = new ResultsVM();
    }

    private void load() {
        resultsVM.load().observe(this, new Observer<Results>() {
            @Override
            public void onChanged(Results r) {
                while (r == null) {

                }
                progressBar.setVisibility(View.GONE);
                swt_sort.setVisibility(View.VISIBLE);
                if (r.getItems().isEmpty()) {
                    Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_LONG).show();
                } else {
                    results = r;
                    show(results.getItems());
                }
            }
        });
    }

    private void show(List<Repository> r) {

        repositoryAdapter = new RepositoryAdapter(getApplicationContext(), r);
        recyclerView.setAdapter(repositoryAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                repositoryAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.swt_sort_by:
                sort();
                break;
        }
    }

    private void sort() {
        if (swt_sort.isChecked()) {
            Collections.sort(results.getItems(), (r1, r2) -> {
                return r1.getName().toLowerCase().compareTo(r2.getName().toLowerCase());
            });
            show(results.getItems());
        } else {
            Collections.sort(results.getItems(), (r1, r2) -> {
                return r2.getStargazers_count() - r1.getStargazers_count();
            });
            show(results.getItems());
        }
    }
}