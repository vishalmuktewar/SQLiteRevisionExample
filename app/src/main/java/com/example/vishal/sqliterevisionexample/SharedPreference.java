package com.example.vishal.sqliterevisionexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreference extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    DBHelper dbHelper;
    private static final String EMP_NAME = "emp_name";

    EditText mEditName,mEditPhoneNumber,mEditSalary,mEditId,mEditAddress;
    Button mInsert,mFetch,mUpdate,mDelete;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        Log.d(TAG, "onCreate: Started");
        final SharedPreferences sharedPreference =  getSharedPreferences("MyRefs",Context.MODE_PRIVATE);

        dbHelper = new DBHelper(this);

        mEditName = findViewById(R.id.et_name);
        mEditPhoneNumber = findViewById(R.id.et_phone);
        mEditSalary = findViewById(R.id.et_salary);
        mEditId = findViewById(R.id.et_id);
        mEditAddress = findViewById(R.id.et_address);

        mInsert = findViewById(R.id.btn_insert);
        mFetch = findViewById(R.id.btn_fetch);
        mUpdate = findViewById(R.id.btn_update);
        mDelete = findViewById(R.id.btn_delete);

        textView = findViewById(R.id.tv_noe);

        mInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on insert");
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString(EMP_NAME,mEditName.getText().toString());
                editor.putString("Employee_Phone_Number",mEditPhoneNumber.getText().toString());
                editor.putString("Employee_Salary",mEditSalary.getText().toString());
                editor.putString("Employee_Address",mEditAddress.getText().toString());
                editor.apply();
            }
        });

        mFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on fetch");
                String emp_name = sharedPreference.getString(EMP_NAME,null);
                String emp_phone = sharedPreference.getString("Emp_Phone",null);
                String emp_salary = sharedPreference.getString("Emp_Salary",null);
                String emp_address = sharedPreference.getString("Emp_address",null);

                if (emp_name != null && emp_phone != null && emp_salary != null && emp_address != null){
                        mFetch.setText(dbHelper.fetch());
                }
            }
        });
    }
}
