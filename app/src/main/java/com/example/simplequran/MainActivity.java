package com.example.simplequran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    TextView txtSurah,txtVerse,txtDisplay;
    QDH qdh = new QDH();
    QuranArabicText txt = new QuranArabicText();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn_display);
        txtSurah=findViewById(R.id.txt_suran_no);
        txtVerse=findViewById(R.id.txt_verse_no);
        txtDisplay=findViewById(R.id.txt_verse);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(R.id.btn_display == view.getId())
        {
            int surah = Integer.parseInt(txtSurah.getText().toString());
            int verse = Integer.parseInt(txtVerse.getText().toString());
            int startingVerse = qdh.SSP[surah - 1];
            String verseStr = txt.QuranArabicText[startingVerse + verse - 1 ];
            txtDisplay.setText(verseStr);
        }
    }


}