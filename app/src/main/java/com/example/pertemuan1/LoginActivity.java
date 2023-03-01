package com.example.pertemuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private String username, password;
    KendaliLogin KL = new KendaliLogin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if(username.trim().equals("")){
                    etUsername.setError("Ini Tidak Boleh Kosong");
                }
                else if(password.trim().equals("")) {
                    etPassword.setError("Ini Tidak Boleh Kosong");
                }
                else {
                    if(username.equals("randie") && password.equals("ggwahyu?"))
                    {
                        KL.setPref(LoginActivity.this, MainActivity.keySPusername, username);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Username atau Password Belum Tepat", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}