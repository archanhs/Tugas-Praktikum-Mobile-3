package com.example.tugasrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detail extends AppCompatActivity {


    TextView textnama, textdetail;
    Button share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        share = findViewById(R.id.share);
        textnama = findViewById(R.id.nama);
        textdetail = findViewById(R.id.deskripsi);

        Bundle bundle = getIntent().getExtras();

        final String nama = bundle.getString("nama");
        final String detail = bundle.getString("detail");

        textnama.setText(nama);
        textdetail.setText(detail);
        textdetail.setMovementMethod(new ScrollingMovementMethod());
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,nama+""+detail);
                share.setType("text/plain");

                Intent shareIntent = Intent.createChooser(share, null);
                startActivity(share);


            }
        });
    }

}
