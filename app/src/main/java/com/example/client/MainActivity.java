package com.example.client;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.client.models.Client;
import com.google.android.material.snackbar.Snackbar;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.sql.PreparedStatement;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnRegister;
    RelativeLayout root;
    ConnectionHelper connectionHelper;
    PreparedStatement statement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn=findViewById(R.id.buttonSignIn);
        btnRegister=findViewById(R.id.buttonRegister);

        root = findViewById(R.id.root_element);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterWindow();
            }
        });
    }

    private void showRegisterWindow() {
        final SetData setData = new SetData();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Зарегистрироваться");
        dialog.setMessage("Введите все данные для регистрации");

        LayoutInflater inflater = LayoutInflater.from(this);
        @SuppressLint("InflateParams") View registerWindow = inflater.inflate(R.layout.register_window, null);
        dialog.setView(registerWindow);

        final MaterialEditText FIO = registerWindow.findViewById(R.id.FIOField);
        final MaterialEditText adress = registerWindow.findViewById(R.id.AdressField);
        final MaterialEditText phone = registerWindow.findViewById(R.id.TelephoneField);
        final MaterialEditText datebirth = registerWindow.findViewById(R.id.BirthDateField);
        final MaterialEditText email = registerWindow.findViewById(R.id.emailField);
        final MaterialEditText password = registerWindow.findViewById(R.id.PasswordField);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (TextUtils.isEmpty(Objects.requireNonNull(FIO.getText()).toString())){
                    Snackbar.make(root, "Введите ваше ФИО", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Objects.requireNonNull(adress.getText()).toString())){
                    Snackbar.make(root, "Введите ваш адрес", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Objects.requireNonNull(phone.getText()).toString())){
                    Snackbar.make(root, "Введите ваш телефон", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Objects.requireNonNull(datebirth.getText()).toString())){
                    Snackbar.make(root, "Введите вашу дату рождения", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Objects.requireNonNull(email.getText()).toString())){
                    Snackbar.make(root, "Введите ваш e-mail", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Objects.requireNonNull(password.getText()).toString())){
                    Snackbar.make(root, "Введите ваш пароль", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                Client client = new Client();
                client.setFIO(FIO.getText().toString());
                client.setAdress(adress.getText().toString());
                client.setPhone(phone.getText().toString());
                client.setBirthdate(datebirth.getText().toString());
                client.setEmail(email.getText().toString());
                client.setPassword(password.getText().toString());

                setData.setRegisterData(client);
            }
        });

        dialog.show();
    }
}
