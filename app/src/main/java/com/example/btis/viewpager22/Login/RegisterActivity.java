package com.example.btis.viewpager22.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btis.viewpager22.PerfilUsuari.ProfileActivity;
import com.example.btis.viewpager22.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class RegisterActivity extends AppCompatActivity {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    EditText txtUsername;
    EditText txtPassword;
    EditText txtEmail;
    EditText txtTwitter;
    EditText txtInstagram;
    Button btRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUsername = (EditText) findViewById(R.id.txtRegisterUsername);
        txtPassword = (EditText) findViewById(R.id.txtRegisterPassword);
        txtEmail =(EditText) findViewById(R.id.txtRegisterEmail);

        txtTwitter = (EditText) findViewById(R.id.txtTwitter);
        txtInstagram = (EditText) findViewById(R.id.txtInstagram);

        btRegister = (Button)findViewById(R.id.btRegister);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegister();
            }
        });
    }

    private void doRegister(){
        boolean validate = true;
        String username = txtUsername.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String twitter = txtTwitter.getText().toString().trim();
        String instagram = txtInstagram.getText().toString().trim();

        // validate input
        if(username.isEmpty()){
            txtUsername.setError("Falta nom d'usuari");
            validate = false;
        }
        if(password.isEmpty()){
            txtPassword.setError("Falta contrasenya");
            validate = false;
        }
        if(!email.matches(EMAIL_PATTERN)){
            txtEmail.setError("Falta Email");
            validate = false;
        }
        if(twitter.isEmpty()){
            txtTwitter.setError("Falta Twitter");
            validate = false;
        }
        if(instagram.isEmpty()){
            txtInstagram.setError("Falta Instagram");
            validate = false;
        }

        // do register
        if(validate= true){

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Usuari registrat correctament ", Toast.LENGTH_SHORT)
                                .show();
                        Bundle social = new Bundle();

                        social.putString("Instagram", String.valueOf(txtInstagram));
                        social.putString("Twitter", String.valueOf(txtTwitter));
                        social.putString("User", String.valueOf(txtUsername));
                        Intent next = new Intent(RegisterActivity.this, ProfileActivity.class);
                        next.putExtras(social);
                        startActivity(next);

                    } else {
                        Toast.makeText(RegisterActivity.this, "Error ", Toast.LENGTH_SHORT)
                                .show();
                        Log.e("Sesion", task.getException().getMessage() + "");
                    }
                }



            });


    }else{
            Toast.makeText(RegisterActivity.this, "Omple tots els camps  ", Toast.LENGTH_SHORT).show();
        }
}

}

