package ac.id.atmaluhur.mhs.TRAVELSOS;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Register extends AppCompatActivity {

    EditText username, password, repassword;
    AppCompatButton daftar;
    ImageView back;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        daftar = findViewById(R.id.daftar);
        back = findViewById(R.id.kembali);
        DB = new DBHelper(this);

        back.setOnClickListener(view ->{
            Intent i = new Intent(Register.this, Login.class);
            startActivity(i);
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(Register.this, "All fields Required",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(Register.this, "Daftar Sukses",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Register.this, "Daftar Gagal",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Register.this, "Nama Sudah Dipakai",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Register.this, "Password tidak valid",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}