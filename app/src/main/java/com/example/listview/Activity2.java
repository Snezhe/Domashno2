package com.example.listview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;

public class Activity2 extends MainActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private EditText editText;

    public static Intent makeIntent(Context context) {
        return new Intent(context, Activity2.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        editText = (EditText) findViewById(R.id.editText1);

        Button addProduct;
        addProduct = findViewById(R.id.addProduct1);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
    }

    public void showAlertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                .setTitle("Порака")
                .setMessage("Дали сакате да внесете?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        if (TextUtils.isEmpty(editText.getText())) {
                            setResult(RESULT_CANCELED, intent);
                        } else {
                            String product = editText.getText().toString();
                            intent.putExtra(EXTRA_REPLY, product);
                            setResult(RESULT_OK, intent);
                        }
                        finish();
                    }
                });
        dialog.setNegativeButton("Не", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.create().show();
    }
}
