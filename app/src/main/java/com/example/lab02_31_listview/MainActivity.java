package com.example.lab02_31_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private void initiateListViewContainer() {
        // Bài 3.1
        ListView lvPerson = findViewById(R.id.lv_person);
        TextView tvSelection = findViewById(R.id.tvSelection);

        final String[] arr = {"Teo", "Ty", "Bin", "Bo", "Teo", "Ty",
                "Bin", "Bo", "Teo", "Ty", "Bin", "Bo", "Teo", "Ty",
                "Bin", "Bo", "Teo", "Ty", "Bin", "Bo", "Teo", "Ty",
                "Bin", "Bo", "Teo", "Ty", "Bin", "Bo", "Teo", "Ty",
                "Bin", "Bo", "Teo", "Ty", "Bin", "Bo"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        lvPerson.setAdapter(adapter);

        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String info = getString(R.string.selection_info, arg2, arr[arg2]);
                tvSelection.setText(info);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initiateListViewContainer();
    }
}