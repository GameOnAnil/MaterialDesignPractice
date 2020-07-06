package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.material.snackbar.Snackbar;

import static com.example.materialdesign.R.id.bottom_app_bar;
import static com.example.materialdesign.R.id.fab_new;

public class BottomAppBar extends AppCompatActivity {

    private com.google.android.material.bottomappbar.BottomAppBar bottomAppBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);

        final CoordinatorLayout container = findViewById(R.id.container_layout);

        bottomAppBar = findViewById(bottom_app_bar);
        setSupportActionBar(bottomAppBar);

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.item1:
                        Snackbar snackbar = Snackbar.make(container,"item1 ",Snackbar.LENGTH_SHORT);
                        snackbar.setAnchorView(fab_new);
                        snackbar.show();
                        break;
                    case R.id.search:
                        Snackbar snackbar2 = Snackbar.make(container,"Search ",Snackbar.LENGTH_SHORT);
                        snackbar2.setAnchorView(fab_new);
                        snackbar2.show();
                        break;
                }
                return false;
            }
        });

         }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_list,menu);
        return super.onCreateOptionsMenu(menu);
    }


}