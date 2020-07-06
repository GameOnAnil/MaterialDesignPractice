package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class AlertDialog extends AppCompatActivity {
    private CharSequence[] person;
    private Boolean[] itemChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        person = new CharSequence[]{"Anil", "James", "harry"};
        itemChoice = new Boolean[]{true,false,false};

        Button button = (Button) findViewById(R.id.btn_alert_dialog);
        final Button type2 = (Button) findViewById(R.id.btn_alert_dialog2);
        final Button type3 = (Button) findViewById(R.id.btn_alert_dialog3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(AlertDialog.this);
                builder.setTitle("Alert Dialog Box");
                builder.setMessage("Welcome to alert dialog ");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar.make(view, "Your pressed yes", Snackbar.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialog.this, "You pressed no!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });


        type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(AlertDialog.this);
                builder.setTitle("Multiple choise type");
                builder.setSingleChoiceItems(person, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar snackbar = Snackbar.make(type2,"Your have chosen: "+person[i],Snackbar.LENGTH_SHORT);
                        snackbar.show();
                        dialogInterface.dismiss();

                    }
                });
                builder.show();

            }
        });

        type3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(AlertDialog.this);
                builder.setTitle("Multiple choice type");
                builder.setMultiChoiceItems(person, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                    }
                });

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       Snackbar.make(type3,"Yes",Snackbar.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar.make(type3,"No",Snackbar.LENGTH_SHORT).show();

                    }
                });
                builder.show();



            }
        });
    }
}