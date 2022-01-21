package ac.id.atmaluhur.mhs.TRAVELSOS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView cardplane, cardbus, cardchat, cardwidget, cardsetting, cardexit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardplane = findViewById(R.id.cardPlane);
        cardbus = findViewById(R.id.cardBus);
        cardchat = findViewById(R.id.cardChat);
        cardwidget = findViewById(R.id.cardWidget);
        cardsetting = findViewById(R.id.cardSetting);
        cardexit = findViewById(R.id.cardExit);

        cardplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Plane Travel");
            }
        });
        cardbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Bus Travel");
            }
        });
        cardchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Chat Clicked");
            }
        });
        cardwidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Widgets Clicked");
            }
        });
        cardsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Settings Clicked");
            }
        });
        cardexit.setOnClickListener(view ->{
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}