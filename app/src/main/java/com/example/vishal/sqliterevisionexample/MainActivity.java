package com.example.vishal.sqliterevisionexample;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DBHelper dbHelper;
    ArrayList<ContactClass> list;

    EditText mEditName,mEditPhoneNumber,mEditSalary,mEditId,mEditAddress;
    Button mInsert,mFetch,mUpdate,mDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        dbHelper = new DBHelper(this);
        TextView textView = findViewById(R.id.tv_address);

        mEditName = findViewById(R.id.et_name);
        mEditPhoneNumber = findViewById(R.id.et_phone);
        mEditSalary = findViewById(R.id.et_salary);
        mEditId = findViewById(R.id.et_id);
        mEditAddress = findViewById(R.id.et_address);

        mInsert = findViewById(R.id.btn_insert);
        mFetch = findViewById(R.id.btn_fetch);
        mUpdate = findViewById(R.id.btn_update);
        mDelete = findViewById(R.id.btn_delete);


        mInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long ret = dbHelper.insert(mEditName.getText().toString(),mEditPhoneNumber.getText().toString(),
                            mEditSalary.getText().toString(), mEditAddress.getText().toString());
                Log.d(TAG, "onClick: Inserted value " + ret);
            }
        });

        mFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
list = dbHelper.fetch();
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("LIST", list);
            }
        });

        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.update(mEditName.getText().toString(),mEditPhoneNumber.getText().toString(),
                                mEditSalary.getText().toString(),mEditAddress.getText().toString(),
                                Integer.parseInt(mEditId.getText().toString()));
            }
        });

        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.delete(Integer.parseInt(mEditId.getText().toString()));
            }
        });

    }

}
