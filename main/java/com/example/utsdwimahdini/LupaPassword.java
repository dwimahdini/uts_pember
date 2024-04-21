package com.example.utsdwimahdini;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LupaPassword extends AppCompatActivity {

    EditText editTextEmail;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lakukan verifikasi alamat email dan kirim permintaan pemulihan password
                String email = editTextEmail.getText().toString().trim();
                if (!email.isEmpty()) {
                    // Jika email tidak kosong, maka kirim permintaan pemulihan password
                    // Di sini Anda dapat menambahkan logika untuk mengirim email pemulihan password

                    // Tampilkan Toast untuk memberi tahu pengguna bahwa permintaan sudah dikirim
                    Toast.makeText(LupaPassword.this, "Kami sudah mengirim link pemulihan password ke email anda", Toast.LENGTH_SHORT).show();
                } else {
                    // Jika email kosong, tampilkan pesan kesalahan
                    Toast.makeText(LupaPassword.this, "Silakan masukkan alamat email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
