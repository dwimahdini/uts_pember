package com.example.utsdwimahdini;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MahasiswaFragment extends Fragment {

    private static final int NUM_OF_DUMMY_DATA = 100;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mahasiswa, container, false);

        TableLayout tableLayout = view.findViewById(R.id.tableLayout);
        HorizontalScrollView horizontalScrollView = view.findViewById(R.id.horizontalScrollView);

        String[] headers = {"Tanggal", "Nama", "NIM", "Email", "Judul", "Aksi"};
        addHeaders(tableLayout, headers);

        for (int i = 0; i < NUM_OF_DUMMY_DATA; i++) {
            String[] dummyData = {"2024-04-21", "Mahasiswa " + (i + 1), "123456" + (i + 1), "dosen" + (i + 1) + "@example.com", "Judul " + (i + 1)};
            addData(tableLayout, dummyData);
        }

        return view;
    }

    private void addHeaders(TableLayout tableLayout, String[] headers) {
        TableRow row = new TableRow(getContext());
        for (String header : headers) {
            TextView textView = new TextView(getContext());
            textView.setText(header);
            textView.setPadding(20, 5, 20, 5);
            row.addView(textView);
        }
        tableLayout.addView(row);
    }

    private void addData(TableLayout tableLayout, String[] data) {
        TableRow row = new TableRow(getContext());
        for (int i = 0; i < data.length - 1; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(data[i]);
            textView.setPadding(20, 5, 20, 5);
            row.addView(textView);
        }

        Button lihatButton = new Button(getContext());
        lihatButton.setText("Lihat");
        lihatButton.setPadding(20, 5, 20, 5);
        lihatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementasi untuk membuka halaman "Lihat"
                Intent intent = new Intent(getContext(), LihatMahasiswa.class);
                startActivity(intent);
            }
        });
        row.addView(lihatButton);

        Button hapusButton = new Button(getContext());
        hapusButton.setText("Hapus");
        hapusButton.setPadding(20, 5, 20, 5);
        hapusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementasi untuk membuka halaman "Hapus"
                Intent intent = new Intent(getContext(), HapusMahasiswa.class);
                startActivity(intent);
            }
        });
        row.addView(hapusButton);

        tableLayout.addView(row);
    }
}
