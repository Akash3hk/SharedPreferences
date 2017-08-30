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

public class login extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText userName = (EditText) view.findViewById(R.id.etUName);
        final EditText password = (EditText) view.findViewById(R.id.etPsw);
        Button btnLogin = (Button) view.findViewById(R.id.btnLogin);
        Button btnRegister = (Button) view.findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("database", Context.MODE_PRIVATE);
                String uName = sharedPreferences.getString("username","no value");
                String psw = sharedPreferences.getString("password","no value");

                if(userName.getText().toString().equals(uName) && password.getText().toString().equals(psw)){

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction tx = fragmentManager.beginTransaction();
                    tx.replace(R.id.mainFrame,new main());
                    tx.commit();

                }

                else {
                    Toast.makeText(getActivity(),"Incorrect Username and Password",Toast.LENGTH_LONG).show();
                    userName.setText("");
                    password.setText("");
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction tx = fragmentManager.beginTransaction();
                tx.replace(R.id.mainFrame,new register());
                tx.commit();
            }
        });

        return view;
    }

}
