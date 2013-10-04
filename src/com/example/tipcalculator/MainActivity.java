package com.example.tipcalculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void updateTipAmount(View view) {

		Button tipPercentageButton = (Button) view;
		Float tipPercentage;
		try {
			Number number = NumberFormat.getPercentInstance().parse(tipPercentageButton.getText().toString());
			tipPercentage = number.floatValue();
		} catch (ParseException e) {
			return;
		}
		EditText amount = (EditText) findViewById(R.id.amount);
		String amountText = amount.getText().toString();

		if (amountText == null || "".equals(amountText)) {
			amountText = "0";
		}

		Float amountValue = Float.valueOf(amountText);

		Float tipAmount = tipPercentage * amountValue;
		TextView tipAmountView = (TextView) findViewById(R.id.tipAmount);

		DecimalFormat df = new DecimalFormat("$0.00");
		tipAmountView.setText(String.valueOf(df.format(tipAmount)));

	}

}
