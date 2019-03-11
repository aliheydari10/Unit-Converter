package com.example.unit;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class HomeActivity extends AppCompatActivity {

    private String[] calculateCantimeter(float cm) {

        float m = cm / 100.0f;
        float km = m / 1000.0f;
        float inch = cm / 2.54f;

        String[] newstr = new String[4];
        newstr[0] =  cm+"cm";
        newstr[1] =m+"m";
        newstr[2] = km+"km";
        newstr[3] =inch+"inch";
        return newstr;


    }

    private String[] calculatemeter(float m) {

        float cm = m * 100.0f;
        float km = m * 1000.0f;
        float inch = cm / 2.54f;

        String[] newstr = new String[4];
        newstr[0] = m+"m";
        newstr[1] = cm+"cm";
        newstr[2] = km+"km";
        newstr[3] = inch+"inch";

        return newstr;

    }

    private String[] calculatekilometer(float km) {

        float cm = km * 100000.0f;
        float m = cm / 100.0f;
        float inch = cm / 2.54f;

        String[] newstr = new String[4];
        newstr[0] = km+"km";
        newstr[1] =  cm+"cm";
        newstr[2] = m+"m";
        newstr[3] = inch+"inch";
        return newstr;


    }

    private String[] calculateinch(float inch) {

        float cm = inch * 2.54f;
        float m = cm / 100.0f;
        float km = m / 1000.0f;
        String[] newstrr = new String[4];
        newstrr[0] = inch+"inch";
        newstrr[1] = cm+"cm";
        newstrr[2] = m+"m";
        newstrr[3] = km+"km";
        return newstrr;


    }

    ConstraintLayout ba;
    ConstraintLayout bn;
    Animation animation;
    Animation animation1;
    Spinner spinner;
    Button btnSend;
    EditText edtTxt;

    int pos;
    Intent intent;
    String[] strarray1;
    String[] strarray2;
    String[] strarray3;
    String[] strarray4;

    float cm;
    float m;
    float km;
    float inch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnSend = findViewById(R.id.btn_send);
        edtTxt = findViewById(R.id.txt_input);
        ba = findViewById(R.id.ba);
        bn = findViewById(R.id.bn);

        intent = new Intent(HomeActivity.this, SecendActivity.class);
        animation = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        animation1 = AnimationUtils.loadAnimation(this, R.anim.top_to_botto);
        ba.startAnimation(animation);

        bn.startAnimation(animation1);

        spinner = findViewById(R.id.spinner_1);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.spinner, R.layout.support_simple_spinner_dropdown_item);
//
//
//        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);


    }

    public void goToResult(View view) {
        pos = spinner.getSelectedItemPosition();

        if (pos == 0) {
            cm = Float.parseFloat(edtTxt.getText().toString());

            strarray1 = new String[4];
            strarray1 = calculateCantimeter(cm);

            intent.putExtra("position", pos);
            intent.putExtra("arraystr", strarray1);
            intent.putExtra("input number", edtTxt.getText().toString());
        } else if (pos == 1) {
            m = Float.parseFloat(edtTxt.getText().toString());
            strarray2 = new String[4];
            strarray2 = calculatemeter(m);
//                    Intent intent = new Intent(HomeActivity.this, SecendActivity.class);
            intent.putExtra("position", pos);
            intent.putExtra("arraystr", strarray2);
            intent.putExtra("input number", edtTxt.getText().toString());
        } else if (pos == 2) {
            km = Float.parseFloat(edtTxt.getText().toString());
            strarray3 = new String[4];
            strarray3 = calculatekilometer(km);
//                    Intent intent = new Intent(HomeActivity.this, SecendActivity.class);
            intent.putExtra("position", pos);
            intent.putExtra("arraystr", strarray3);
            intent.putExtra("input number", edtTxt.getText().toString());

        } else if (pos == 3) {
            inch = Float.parseFloat(edtTxt.getText().toString());

            strarray4 = (String[]) calculateinch(inch);
            strarray4 = calculatekilometer(inch);

//                    Intent intent = new Intent(HomeActivity.this, SecendActivity.class);
            intent.putExtra("position", pos);
            intent.putExtra("arraystr", strarray4);
            intent.putExtra("input number", edtTxt.getText().toString());
        }

        startActivity(intent);
    }
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
//
//
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (position==0){
//
//                float cm=Float.parseFloat(edtTxt.getText().toString());
//
//                String[] strarray=new String[4];
//                strarray=calculateCantimeter(cm);
//                Intent intent=new Intent(HomeActivity.this,SecendActivity.class);
//                intent.putExtra("position",position);
//                intent.putExtra("arraystr",strarray);
//                intent.putExtra("input number",edtTxt.getText().toString());
//                startActivity(intent);
//
//                }
//
//                if (position==1){
//                    float m=Float.parseFloat(edtTxt.getText().toString());
//                    String[] strarray1=new String[4];
//                    strarray1=calculatemeter(m);
//                    Intent intent=new Intent(HomeActivity.this,SecendActivity.class);
//                    intent.putExtra("position",position);
//                    intent.putExtra("arraystr",strarray1);
//                    intent.putExtra("input number",edtTxt.getText().toString());
//                    startActivity(intent);
//
//
//                }
//
//                if (position==2){
//
//                    float km=Float.parseFloat(edtTxt.getText().toString());
//                    String[] strarray2=new String[4];
//                    strarray2=calculatekilometer(km);
//                    Intent intent=new Intent(HomeActivity.this,SecendActivity.class);
//                    intent.putExtra("position",position);
//                    intent.putExtra("arraystr",strarray2);
//                    intent.putExtra("input number",edtTxt.getText().toString());
//                    startActivity(intent);
//
//                }
//
//                if (position==3){
//
//                    float inch=Float.parseFloat(edtTxt.getText().toString());
//                    String[] strarray3=new String[4];
//                    strarray3= (String[]) calculateinch(inch);
//
//                    Intent intent=new Intent(HomeActivity.this,SecendActivity.class);
//                    intent.putExtra("position",position);
//                    intent.putExtra("arraystr",strarray3);
//                    intent.putExtra("input number",edtTxt.getText().toString());
//                    startActivity(intent);
//
//
//
//                }
//
//
//
//
//            }


//
//
//
//        });
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
}
