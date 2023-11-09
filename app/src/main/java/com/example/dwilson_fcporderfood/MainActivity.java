package com.example.dwilson_fcporderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnWings,btnNachos,btnDog,btnBurger,btnChicken,btnFries,btnRings,btnSoda;

    String choices = "";
    Double price = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWings = (Button) findViewById(R.id.btnWings);
        btnNachos = (Button) findViewById(R.id.btnNachos);
        btnDog = (Button) findViewById(R.id.btnDog);
        btnBurger = (Button) findViewById(R.id.btnBurger);
        btnChicken = (Button) findViewById(R.id.btnChicken);
        btnFries = (Button) findViewById(R.id.btnFries);
        btnRings = (Button) findViewById(R.id.btnRings);
        btnSoda = (Button) findViewById(R.id.btnSoda);

    }

    public void add_to_order(View view) {
        if (view == findViewById(R.id.btnWings) )
        {
            choices = choices+"$8.00  Bone-In Wings"+"\n";
            price = price+8;
        }

        else if (view == findViewById(R.id.btnNachos) )
        {
            choices = choices+"$5.00  Nachos & Cheese"+"\n";
            price = price+5;
        }

        else if (view == findViewById(R.id.btnDog) )
        {
            choices = choices+"$5.00  Grilled All Beef Dog"+"\n";
            price = price+5;
        }

        else if (view == findViewById(R.id.btnBurger) )
        {
            choices = choices+"$7.00  Green Chili Burger"+"\n";
            price = price+7;
        }

        else if (view == findViewById(R.id.btnChicken) )
        {
            choices = choices+"$8.00  Grilled Chicken Sandwich"+"\n";
            price = price+8;
        }

        else if (view == findViewById(R.id.btnFries) )
        {
            choices = choices+"$3.00  French Fries"+"\n";
            price = price+3;
        }

        else if (view == findViewById(R.id.btnRings) )
        {
            choices = choices+"$4.00  Beer Battered Onion Rings"+"\n";
            price = price+4;
        }

        else if (view == findViewById(R.id.btnSoda) )
        {
            choices = choices+"$1.00  Soda Pop"+"\n";
            price = price+1;
        }
    }

    public void reviewOrder(View view) {

        Intent i = new Intent(MainActivity.this, OrderDetails.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices",choices);
        bundle.putDouble("price",price);
        i.putExtras(bundle);
        startActivity(i);
    }
}