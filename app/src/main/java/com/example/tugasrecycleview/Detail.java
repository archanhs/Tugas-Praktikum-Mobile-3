package com.example.tugasrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Detail extends AppCompatActivity {


    TextView textnama, textdetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textnama = findViewById(R.id.nama);
        textdetail = findViewById(R.id.deskripsi);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        String detail = bundle.getString("detail");

        textnama.setText(nama);
        textdetail.setText(detail);
        textdetail.setMovementMethod(new ScrollingMovementMethod());
    }

}
