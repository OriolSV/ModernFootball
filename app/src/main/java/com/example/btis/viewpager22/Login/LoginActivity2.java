package com.example.btis.viewpager22.Login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.btis.viewpager22.PerfilUsuari.MainActivity;
import com.example.btis.viewpager22.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button buttonRegister, buttonSignIn;
    EditText editTextEmail, editTextPass;

    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonRegister = (Button) findViewById(R.id.btnLogin);
        buttonSignIn = (Button) findViewById(R.id.btnToRegister);
        editTextEmail = (EditText) findViewById(R.id.txtMail);
        editTextPass = (EditText) findViewById(R.id.txtPass);

        buttonRegister.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Log.i("Sesion", "sesion iniciada con email: "+user.getEmail());
                    Intent next = new Intent (LoginActivity2.this, MainActivity.class);
                    startActivity(next);
                }else{
                    Log.i("Sesion", "sesion cerrada");
                }
            }
        };

    }

    private void registrar (final String email, String pass){


        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity2.this, "Usuari registrat: "+ email  , Toast.LENGTH_SHORT)
                            .show();
                    Intent next = new Intent (LoginActivity2.this, MainActivity.class);
                    startActivity(next);
                }else{
                    Toast.makeText(LoginActivity2.this, "Error " , Toast.LENGTH_SHORT)
                            .show();
                    Log.e("Sesion", task.getException().getMessage()+"");
                }
            }
        });

    }

    private void iniciarSesion (final String email, String pass){

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity2.this, "Sessió iniciada como: "+ email  , Toast.LENGTH_SHORT)
                            .show();

                    Intent next = new Intent (LoginActivity2.this, MainActivity.class);
                    startActivity(next);
                }else{
                    Toast.makeText(LoginActivity2.this, "Usuari o contrasenya incorrectesa", Toast.LENGTH_SHORT)
                            .show();
                    Log.e("Sesion", task.getException().getMessage()+"");

                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                String emailLogin = editTextEmail.getText().toString();
                String passLogin = editTextPass.getText().toString();
                iniciarSesion(emailLogin,passLogin);

                break;
            case R.id.btnToRegister:
                String emailRegister = editTextEmail.getText().toString();
                String passRegister = editTextPass.getText().toString();
                registrar(emailRegister,passRegister);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);

    }

    @Override
    protected void onStop() {
        super.onStop();
       /* if (mAuthListener !=null){
          FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }*/
    FirebaseAuth.getInstance().signOut();
    }
}
