package com.example.utsdwimahdini;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class PembimbingFragment extends Fragment {
    private TableLayout tableLayout;

    public PembimbingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.pembimbing, container, false);

        // Get the TableLayout
        tableLayout = rootView.findViewById(R.id.table_dosen);

        // Add a button to add a new professor
        Button addButton = rootView.findViewById(R.id.button_add_dosen);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahDosen();
            }
        });

        // Populate the table with dummy data (for initial display)
        populateDummyData();

        return rootView;
    }

    // Method to add a new row for a professor
    private void tambahDosen() {
        TableRow row = new TableRow(getActivity());

        // Placeholder data for the new professor
        String[] newDosenData = {"", "Nama Dosen Baru", "NIDN Baru", "Jenis Kelamin", "Keahlian", "Kuota"};

        for (String cellData : newDosenData) {
            TextView textView = new TextView(getActivity());
            textView.setText(cellData);
            textView.setPadding(8, 8, 8, 8);
            row.addView(textView);
        }

        Button btnEdit = new Button(getActivity());
        btnEdit.setText("Edit");
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle edit button click
                // For example, you can start a new activity to edit the data
                Intent intent = new Intent(getActivity(), EditPembimbing.class);
                // Pass any necessary data to the activity
                // For example, you can pass the NIDN to identify which professor to edit
                intent.putExtra("NIDN", "NIDN Baru"); // Example, you should replace with the actual NIDN
                startActivity(intent);
            }
        });
        row.addView(btnEdit);

        // Add the new row to the table
        tableLayout.addView(row);
    }

    // Method to populate the table with dummy data (for initial display)
    private void populateDummyData() {
        String[][] dummyData = {
                {"1", "John Doe", "1234567890", "Male", "Computer Science", "10"},
                {"2", "Jane Smith", "0987654321", "Female", "Mathematics", "8"},
                {"3", "Alice Johnson", "5678901234", "Female", "Physics", "12"},
                // Add more dummy data as needed
        };

        for (final String[] rowData : dummyData) {
            TableRow row = new TableRow(getActivity());

            for (String cellData : rowData) {
                TextView textView = new TextView(getActivity());
                textView.setText(cellData);
                textView.setPadding(8, 8, 8, 8);
                row.addView(textView);
            }

            Button btnEdit = new Button(getActivity());
            btnEdit.setText("Edit");
            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle edit button click
                    Intent intent = new Intent(getActivity(), EditPembimbing.class);
                    intent.putExtra("NIDN", rowData[2]); // Assuming NIDN is at index 2 in rowData
                    startActivity(intent);
                }
            });
            row.addView(btnEdit);

            // Add the row to the table
            tableLayout.addView(row);
        }
    }
}
