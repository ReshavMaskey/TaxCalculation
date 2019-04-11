package com.example.taxcalculation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtIncome;
    Button btnTax, btnClose;
    TextView txtResult;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        hideActionBar();
        btnClose = findViewById(R.id.btnClose);
        btnTax = findViewById(R.id.btnTax);
        txtResult = findViewById(R.id.txtResult);
        txtIncome = findViewById(R.id.txtIncome);
        btnTax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int income = Integer.parseInt(txtIncome.getText().toString());
                TaxLogic taxLogic = new TaxLogic(income);
                txtResult.setText("TAX Amount: [ "+Integer.toString(taxLogic.getTaxSummary())+" ]");
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btnTax.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert("Do you want to close application");
            }
        });

    }

    private void hideActionBar() {
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void showAlert(String message) {

        builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Toast.makeText(MainActivity.this, "YES!!!", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(MainActivity.this, "NO!!!", Toast.LENGTH_LONG).show();


                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle("Message");
        alert.show();
    }
}
