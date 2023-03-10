package com.example.gallery;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
//import android.graphics.Picture;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayPicture(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(id);
        String tag = (String) layout.getTag();

        //Toast.makeText(this, "클릭한 아이템(태그)" + tag, Toast.LENGTH_LONG).show();

        Intent it =new Intent(this, Picture.class);
        it.putExtra("it_tag", tag);
        startActivity(it);
    }
}



