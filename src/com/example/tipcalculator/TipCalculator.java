package com.example.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
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

		String number = tipPercentageButton.getTag().toString();
		tipPercentage = Float.parseFloat(number);

		EditText amount = (EditText) findViewById(R.id.amount);
		String amountText = amount.getText().toString();

		if (amountText == null || "".equals(amountText)) {
			amountText = "0";
		}

		Float amountValue = Float.valueOf(amountText);

		Float tipAmount = tipPercentage * amountValue;
		TextView tipAmountView = (TextView) findViewById(R.id.tipAmount);

		DecimalFormat df = new DecimalFormat(getResources().getString(R.string.NUMBER_FORMAT));
		tipAmountView.setText(String.valueOf(df.format(tipAmount)));

	}

}
