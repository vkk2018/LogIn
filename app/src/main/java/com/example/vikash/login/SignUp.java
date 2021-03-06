package com.example.vikash.login;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    public EditText editText1;
    public   EditText editText2;
    public   EditText editText3;
    public   EditText editText4;
    public   EditText editText5;
    public   EditText editText6;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editText1 = (EditText)findViewById(R.id.t1);
        editText2 = (EditText)findViewById(R.id.t2);
        editText3 = (EditText)findViewById(R.id.t3);
        editText4 = (EditText)findViewById(R.id.t4);
        editText5 = (EditText)findViewById(R.id.t5);
        editText6 = (EditText)findViewById(R.id.t6);
        button = (Button)findViewById(R.id.b1);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String str1 = editText5.getText().toString();
                final String str2 = editText6.getText().toString();
                final String str3 = editText4.getText().toString();
                final String str4 = editText3.getText().toString();
                final String str5 = editText2.getText().toString();
                final String str6 = editText1.getText().toString();
                String email = editText4.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                String firstName = editText1.getText().toString().trim();
                String lastName = editText2.getText().toString().trim();
                String matchName = "[a-zA-Z0-9]+";

                if (str1.matches("") || str2.matches("") || str3.matches("")
                        || str4.matches("") || str5.matches("") || str6.matches(""))
                {

                    Toast.makeText(SignUp.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }

                else {

                    if(firstName.matches(matchName)  ) {

                        if(lastName.matches(matchName)) {

                            if (str4.length() < 10) {
                                Toast.makeText(SignUp.this, "Enter valid mobile number", Toast.LENGTH_SHORT).show();
                            } else {


                                if (email.matches(emailPattern)) {

                                    if ((str1.length() >= 8) && (str2.length() >= 8)) {


                                        if (str1.equals(str2)) {
                                            startActivity(new Intent(getApplicationContext(), com.example.vikash.login.progressbar.class));

                                            final Handler handler = new Handler();
                                            handler.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(SignUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                                    editText1.setText("");
                                                    editText2.setText("");
                                                    editText3.setText("");
                                                    editText4.setText("");
                                                    editText5.setText("");
                                                    editText6.setText("");
//
                                                    insertIntoMainTable(str6 ,str5 ,str4 ,str3,str2);
                                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                                                }
                                            }, 1800);


                                        } else {
                                            Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(SignUp.this, "Password 8 characters", Toast.LENGTH_SHORT).show();
                                    }


                                } else

                                {
                                    Toast.makeText(SignUp.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();

                                }
                            }
                        }else
                        {
                            Toast.makeText(SignUp.this, "LastName contains alphabets only", Toast.LENGTH_SHORT).show();
                        }

                    }else
                    {
                        Toast.makeText(SignUp.this, "FirstName contains alphabets only", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    private void insertIntoMainTable( String name, String userName, String mobileNo, String email, String password) {
        VolleyConnect volly = new VolleyConnect(getBaseContext(),"http://192.168.43.49/v4/api/tmp/main/main_insert_new_data.php");
        volly.RegisterInMain(name, userName, mobileNo, email, password);
    }




}

