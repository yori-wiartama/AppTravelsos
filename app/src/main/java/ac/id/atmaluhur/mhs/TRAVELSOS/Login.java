package ac.id.atmaluhur.mhs.TRAVELSOS;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;


public class Login extends AppCompatActivity {

    EditText username, password;
    AppCompatButton login;
    DBHelper DB;
    TextView menu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        menu1 = findViewById(R.id.daftar);

        menu1.setOnClickListener(view ->{
            Intent i = new Intent(Login.this, Register.class);
            startActivity(i);
        });

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        login = findViewById(R.id.login1);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(Login.this, "All fields Required",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this, "Login Sukses",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login.this, "Login Gagal",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}