package com.example.dwilson_fcporderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class OrderDetails extends AppCompatActivity {

    TextView orderView, priceView;
    String list_choice;
    Double totalPrice;
    Button submitButton;
    DecimalFormat money = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        orderView = (TextView) findViewById(R.id.orderView);
        priceView = (TextView) findViewById(R.id.priceView);
        submitButton = findViewById(R.id.submit);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.tadasound);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderDetails.this, "Your American Grill Order is Sent!", Toast.LENGTH_LONG).show();
                mediaPlayer.start();
            }
        });

        Bundle bundle = getIntent().getExtras();
        list_choice = bundle.getString("choices");
        totalPrice = bundle.getDouble("price");
        money.format(totalPrice);
        orderView.setText(list_choice);
        priceView.setText(String.format("Current Total: $%.2f", totalPrice));
        // priceView.setText(String.format("Current Total: $%s", totalPrice.toString()));
    }

    public void mainMenu(View view) {
        Intent intent = new Intent(OrderDetails.this, MainActivity.class);
        this.startActivity(intent);
    }
}