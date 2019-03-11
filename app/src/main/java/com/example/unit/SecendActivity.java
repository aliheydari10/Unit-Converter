package com.example.unit;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SecendActivity extends AppCompatActivity {


    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    ConstraintLayout ttt1;
    Animation animation;
    String[] strings;
    Animation ccc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);


        ttt1 = findViewById(R.id.ttt1);
        animation = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);

        ttt1.startAnimation(animation);


        Bundle bundle = getIntent().getExtras();
        strings = new String[4];
        strings = bundle.getStringArray("arraystr");

        int pos = bundle.getInt("position");


        textView.setText(strings[0]);
        textView2.setText(strings[1]);
        textView3.setText(strings[2]);
        textView4.setText(strings[3]);





    }


    @Override
    public void onBackPressed() {

        Intent intent=new Intent(SecendActivity.this,HomeActivity.class);
        startActivity(intent);


    }
}
