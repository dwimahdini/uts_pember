package com.example.utsdwimahdini;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class TambahPenguji extends AppCompatActivity {

    EditText editTextNama, editTextNIDM, editTextKeahlian;
    Spinner spinnerGender, spinnerKuota;
    Button buttonSimpan, buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_penguji);

        editTextNama = findViewById(R.id.editTextNama);
        editTextNIDM = findViewById(R.id.editTextNIDM);
        editTextKeahlian = findViewById(R.id.editTextKeahlian);
        spinnerGender = findViewById(R.id.spinnerGender);
        spinnerKuota = findViewById(R.id.spinnerKuota);
        buttonSimpan = findViewById(R.id.buttonSimpan);
        buttonKembali = findViewById(R.id.buttonKembali);

        // Setup spinner for gender
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(genderAdapter);

        // Setup spinner for kuota
        ArrayAdapter<CharSequence> kuotaAdapter = ArrayAdapter.createFromResource(this,
                R.array.kuota_array, android.R.layout.simple_spinner_item);
        kuotaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKuota.setAdapter(kuotaAdapter);

        // Set onclick listener for button Simpan
        buttonSimpan.setOnClickListener(view -> simpanData());

        // Set onclick listener for button Kembali
        buttonKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed(); // Kembali ke aktivitas sebelumnya
            }
        });
    }

    private void simpanData() {
        String nama = editTextNama.getText().toString();
        String nidm = editTextNIDM.getText().toString();
        String gender = spinnerGender.getSelectedItem().toString();
        String kuota = spinnerKuota.getSelectedItem().toString();
        String keahlian = editTextKeahlian.getText().toString();

        // Perform saving data or other operations as needed
    }
}
