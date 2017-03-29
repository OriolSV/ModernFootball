package com.example.btis.viewpager22.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btis.viewpager22.PerfilUsuari.MainActivity;
import com.example.btis.viewpager22.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        EditText txtMail = (EditText) findViewById(R.id.txtMail);
        EditText txPass = (EditText) findViewById(R.id.txtPass);
        CheckBox chkPass = (CheckBox) findViewById(R.id.chkPass);
      //  Button logIn = (Button) findViewById(R.id.btnLogin);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnToRegister).setOnClickListener(this);
       // Button register = (Button) findViewById(R.id.btnToRegister);

    }




    @Override
    public void onClick(View v) {

        EditText txtMail = (EditText) findViewById(R.id.txtMail);
        EditText txtPass = (EditText) findViewById(R.id.txtPass);
        String loginMail;
        String loginPass;

        switch (v.getId()){

            case R.id.btnLogin:

               loginMail = txtMail.getText().toString();
               loginPass = txtPass.getText().toString();

                if (loginMail.equals("oriol.santacana@gmail.com") && loginPass.equals("1234") ){

                    Intent next = new Intent (LoginActivity.this, MainActivity.class);
                    startActivity(next);
                }

                else {
                    Toast.makeText(this,"Usuari incorrecte", Toast.LENGTH_LONG).show();

                }
                break;

            case R.id.btnToRegister:

                Toast.makeText(this, "Próximamente...", Toast.LENGTH_LONG).show();

                break;
        }
    }


}

/*
if (chkPass.isChecked()) {
        txtPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        } else {
        txtPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
        break;*/