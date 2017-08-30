package com.practice.sharedpreferences;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends Fragment {

    EditText userName, email, phone, password;
    Button btnSubmit;
    String data_userName, data_email, data_phone, data_password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        userName = (EditText) view.findViewById(R.id.etUName);
        email = (EditText) view.findViewById(R.id.etEmail);
        phone = (EditText) view.findViewById(R.id.etPhoneNo);
        password = (EditText) view.findViewById(R.id.etPsw);
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_userName = userName.getText().toString();
                data_email = email.getText().toString();
                data_phone = phone.getText().toString();
                data_password = password.getText().toString();

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("database", Context.MODE_PRIVATE);
                SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
                sharedPreferencesEditor.putString("username",data_userName);
                sharedPreferencesEditor.putString("email",data_email);
                sharedPreferencesEditor.putString("phone",data_phone);
                sharedPreferencesEditor.putString("password",data_password);
                sharedPreferencesEditor.commit();

                Toast.makeText(getActivity(),"Registered",Toast.LENGTH_LONG).show();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction tx = fragmentManager.beginTransaction();
                tx.replace(R.id.mainFrame,new login());
                tx.commit();

            }
        });
        return view;
    }

}
