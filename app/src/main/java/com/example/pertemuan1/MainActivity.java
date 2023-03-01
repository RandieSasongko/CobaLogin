package com.example.pertemuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvSesi;
    private Button btnLogout;
    private String sesi;
    KendaliLogin KL = new KendaliLogin();

    public static String keySPusername = "GtPJAx45lMjkuICbExYELQ==_username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(KL.isLogin(MainActivity.this, keySPusername) == true){
            setContentView(R.layout.activity_main);

            sesi = KL.getPref(MainActivity.this, keySPusername);
            tvSesi = findViewById(R.id.tv_sesi);
            btnLogout = findViewById(R.id.btn_logout);

            tvSesi.setText(sesi);

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KL.setPref(MainActivity.this, keySPusername, null);
                    startActivity(new Intent(MainActivity.this, null));
                    finish();
                }
            });
        }
        else {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }

        tvSesi = findViewById(R.id.tv_sesi);
        btnLogout = findViewById(R.id.btn_logout);
    }
}