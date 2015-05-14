package com.lina.calculatenetprice;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity{

    EditText textInput;
    TextView textInputDiskon,textOutput;
    Button btnHitung;
    RadioButton itemBaju,itemKemeja,itemGamis,itemJas;


    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //find elements
            //text
            textInput = (EditText)findViewById(R.id.textHarga);
            textInputDiskon=(TextView)findViewById(R.id.textDiskon);
            textOutput = (TextView)findViewById(R.id.hargaNetto);


            //button
            btnHitung = (Button)findViewById(R.id.buttonHitung);

            //radio button
            itemBaju = (RadioButton)findViewById(R.id.itmBaju);
            itemKemeja = (RadioButton)findViewById(R.id.itmKemeja);
            itemGamis = (RadioButton)findViewById(R.id.itmGamis);
            itemJas = (RadioButton)findViewById(R.id.itmJas);

            //set a listener
            itemBaju.setOnClickListener(radio);
            itemKemeja.setOnClickListener(radio);
            itemGamis.setOnClickListener(radio);
            itemJas.setOnClickListener(radio);
            btnHitung.setOnClickListener(button);

       }

//Listener for button
    View.OnClickListener button = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double input = 0;
            double inputDiskon;
            double output = 0;

            if(TextUtils.isEmpty(textInput.getText().toString())){
                return;
            }

            input = Double.parseDouble(textInput.getText().toString());
            inputDiskon = (Double.parseDouble(textInputDiskon.getText().toString()))/100;
            double totalDiskon = input*inputDiskon;
            double hargaNetto = input - totalDiskon;
            textOutput.setText(String.valueOf(hargaNetto));
        }
    };

    //Listener for Radio Button
    View.OnClickListener radio = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.itmBaju:
                    if (checked)
                        itemJas.setChecked(false);
                        itemGamis.setChecked(false);
                        itemKemeja.setChecked(false);
                        textInputDiskon.setText("45");
                    break;
                case R.id.itmKemeja:
                    if (checked)
                        itemJas.setChecked(false);
                        itemGamis.setChecked(false);
                        itemBaju.setChecked(false);
                        textInputDiskon.setText("50");
                    break;
                case R.id.itmGamis:
                    if (checked)
                        itemJas.setChecked(false);
                        itemKemeja.setChecked(false);
                        itemBaju.setChecked(false);
                        textInputDiskon.setText("55");
                    break;
                case R.id.itmJas:
                    if(checked)
                        itemKemeja.setChecked(false);
                        itemGamis.setChecked(false);
                        itemBaju.setChecked(false);
                        textInputDiskon.setText("60");
                    break;
            }
        }
    };
}
