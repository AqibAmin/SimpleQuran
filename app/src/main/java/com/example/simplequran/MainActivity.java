package com.example.simplequran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    ImageButton btn_git;
    TextView txtSurah,txtVerse,txtDisplay;
    QDH qdh = new QDH();
    QuranArabicText txt = new QuranArabicText();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn_display);
        btn_git=findViewById(R.id.btn_img);
        txtSurah=findViewById(R.id.txt_suran_no);
        txtVerse=findViewById(R.id.txt_verse_no);
        txtDisplay=findViewById(R.id.txt_verse);
        btn_git.setOnClickListener(this);
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
        if(R.id.btn_img == view.getId())
        {
            Uri webpage = Uri.parse("https://github.com/AqibAmin/SimpleQuran");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        }
    }
}