package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class FloatingActionBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_bar);

        final CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator);

        FloatingActionButton fab_main = (FloatingActionButton) findViewById(R.id.fab_main);
        ExtendedFloatingActionButton fab_extended = (ExtendedFloatingActionButton) findViewById(R.id.fab_extended);
        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout,"You pressed FAB",Snackbar.LENGTH_SHORT);
                snackbar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);

                snackbar.show();
            }
        });

        fab_extended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(FloatingActionBar.this);
                builder.setMessage("this is extended button");
                builder.setTitle("Extended fab button");
                builder.show();
            }
        });
    }
}