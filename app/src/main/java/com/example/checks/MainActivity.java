package com.example.checks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listVi);

        String[] datos = {"Time", "CheckBox", "Checks", "Web", "Dialogo"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);

        listView.setAdapter(adapter);
        mostrarDialogo();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                Intent intent;

                switch (selectedItem) {
                    case "Time":
                        intent = new Intent(MainActivity.this, time.class);
                        break;
                    case "CheckBox":
                        intent = new Intent(MainActivity.this, check.class);
                        break;
                    case "Checks":
                        intent = new Intent(MainActivity.this, checks.class);
                        break;
                    case "Web":
                        intent = new Intent(MainActivity.this, web.class);
                        break;
                    case "Dialog":
                        intent = new Intent(MainActivity.this, MiDialogo.class);
                        break;


                    default:
                        return;
                }

                intent.putExtra("selectedItem", selectedItem);

                startActivity(intent);

                switch (selectedItem) {

                    case "Dialogo":
                        mostrarDialogo();


                        break;
                    default:
                        return;

                }
            }
        });
    }

    private void mostrarDialogo() {
        MiDialogo miDialogo = new MiDialogo();

        FragmentManager fragmentManager = getSupportFragmentManager();

        miDialogo.show(fragmentManager, "MiDialogoTag");
    }
}
