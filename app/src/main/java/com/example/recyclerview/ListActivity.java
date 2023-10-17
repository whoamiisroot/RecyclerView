package com.example.recyclerview;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import beans.Star;
import service.StarService;

public class ListActivity extends AppCompatActivity {
    private List<Star> stars;
    private RecyclerView recyclerView;
    private StarAdapter starAdapter = null;
    StarService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        stars = new ArrayList<>();
        service = StarService.getInstance();
        init();
        recyclerView = findViewById(R.id.recycle_view);
        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (starAdapter != null) {
                    starAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });
        return true;
    }

    public void init() {

        service.create(new Star("Tom Hardy", "https://randomuser.me/api/portraits/men/70.jpg", 3.5f));
        service.create(new Star("Chris Hemsworth", "https://randomuser.me/api/portraits/men/71.jpg", 3.0f));
        service.create(new Star("Idris Elba", "https://randomuser.me/api/portraits/men/72.jpg", 3.0f));
        service.create(new Star("Michael B. Jordan", "https://randomuser.me/api/portraits/men/73.jpg", 3.0f));
        service.create(new Star("Brad Pitt", "https://randomuser.me/api/portraits/men/77.jpg", 3.0f));
        service.create(new Star("Robert Downey Jr.", "https://randomuser.me/api/portraits/men/78.jpg", 3.0f));
        service.create(new Star("Chris Evans", "https://randomuser.me/api/portraits/men/76.jpg", 3.0f));



    }
}