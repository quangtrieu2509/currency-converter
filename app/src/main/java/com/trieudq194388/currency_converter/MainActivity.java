package com.trieudq194388.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.trieudq194388.currency_converter.Model.CurrencyList;
import com.trieudq194388.currency_converter.Model.CurrencyUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String CURRENCY_1 = "CURRENCY_1";
    private static final String CURRENCY_2 = "CURRENCY_2";
    private static final String INPUT_TEXTVIEW = "INPUT_TEXTVIEW";
    private static final String INPUT_BUTTON = "INPUT_BUTTON";
    private static final String DOT_BUTTON = "DOT_BUTTON";

    private ArrayList<String> spinnerList = new ArrayList<>();
    private Spinner spinner1, spinner2;
    private TextView currSymbol1, currSymbol2, exRateInfor;
    private TextView currencyInput1, currencyInput2;
    private int srcCurrency, desCurrency;
    private String previousClick, currentSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        CurrencyList.init();
        CurrencyList.initSpinnerArray();
        spinnerList = CurrencyList.spinnerList;

        init(); //set default

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(currentSelected.equals(CURRENCY_1)){
                    srcCurrency = position;
                    double cNum = Double.parseDouble(getInputValue(currencyInput1));
                    currencyInput2.setText(doubleToStringWithComma(calculateExRate(cNum, false)));
                }
                else{
                    desCurrency = position;
                    double cNum = Double.parseDouble(getInputValue(currencyInput2));
                    currencyInput1.setText(doubleToStringWithComma(calculateExRate(cNum, false)));
                }
                currSymbol1.setText(CurrencyList.cList.get(position).getSymbol());
                setExRateInfor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(currentSelected.equals(CURRENCY_2)){
                    srcCurrency = position;
                    double cNum = Double.parseDouble(getInputValue(currencyInput2));
                    currencyInput1.setText(doubleToStringWithComma(calculateExRate(cNum, false)));
                }
                else{
                    desCurrency = position;
                    double cNum = Double.parseDouble(getInputValue(currencyInput1));
                    currencyInput2.setText(doubleToStringWithComma(calculateExRate(cNum, false)));
                }
                currSymbol2.setText(CurrencyList.cList.get(position).getSymbol());
                setExRateInfor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        currencyInput1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOnClick(CURRENCY_1);
            }
        });

        currencyInput2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOnClick(CURRENCY_2);
            }
        });

    }

    private void mapping(){
        spinner1 = findViewById(R.id.currSpinner1);
        spinner2 = findViewById(R.id.currSpinner2);
        currSymbol1 = findViewById(R.id.currSymbol1);
        currSymbol2 = findViewById(R.id.currSymbol2);
        exRateInfor = findViewById(R.id.exchangeRate);
        currencyInput1 = findViewById(R.id.currencyInput1);
        currencyInput2 = findViewById(R.id.currencyInput2);
    }

    @SuppressLint("SetTextI18n")
    private void init(){
        srcCurrency = 30;
        desCurrency = 32;

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(arrayAdapter);
        spinner1.setSelection(srcCurrency);
        spinner2.setAdapter(arrayAdapter);
        spinner2.setSelection(desCurrency);

        currSymbol1.setText(CurrencyList.cList.get(srcCurrency).getSymbol());
        currSymbol2.setText(CurrencyList.cList.get(desCurrency).getSymbol());

        inputOnClick(CURRENCY_1);
    }

    @SuppressLint("SetTextI18n")
    private void numberAction(String number){

        if(currentSelected.equals(CURRENCY_1))
            subNumberAction(currencyInput1, currencyInput2, number);
        else
            subNumberAction(currencyInput2, currencyInput1, number);

        previousClick = INPUT_BUTTON;
    }
    private void subNumberAction(TextView src, TextView des, String number){
        String tmp = getInputValue(src);
        if(previousClick.equals(INPUT_TEXTVIEW)){
            src.setText(number);
        }
        else if(previousClick.equals(DOT_BUTTON)){
            int cNum = (int) Double.parseDouble(tmp);
            src.setText(doubleToStringWithComma(cNum + "." + number));

        }else src.setText(doubleToStringWithComma(tmp + number));

        double cNum = Double.parseDouble(getInputValue(src));
        des.setText(doubleToStringWithComma(calculateExRate(cNum, false)));
    }

    public void sevenBtnOnClick(View view) {
        numberAction("7");
    }
    public void eightBtnOnClick(View view) {
        numberAction("8");
    }
    public void nineBtnOnClick(View view) {
        numberAction("9");
    }
    public void fourBtnOnClick(View view) {
        numberAction("4");
    }
    public void fiveBtnOnClick(View view) {
        numberAction("5");
    }
    public void sixBtnOnClick(View view) {
        numberAction("6");
    }
    public void oneBtnOnClick(View view) {
        numberAction("1");
    }
    public void twoBtnOnClick(View view) {
        numberAction("2");
    }
    public void threeBtnOnClick(View view) {
        numberAction("3");
    }
    public void zeroBtnOnClick(View view) {
        numberAction("0");
    }

    public void bsBtnOnClick(View view) {
        if(currentSelected.equals(CURRENCY_1))
            subBsBtnOnClick(currencyInput1, currencyInput2, view);
        else
            subBsBtnOnClick(currencyInput2, currencyInput1, view);

        previousClick = INPUT_BUTTON;
    }
    private void subBsBtnOnClick(TextView src, TextView des, View view){
        String tmp = getInputValue(src);

        if(previousClick.equals(INPUT_TEXTVIEW)) ceBtnOnClick(view);
        else{
            int len = tmp.length();
            if(len == 1) tmp = "0";
            else if(tmp.charAt(len-2) == '.') tmp = tmp.substring(0, len - 2);
            else tmp = tmp.substring(0, len - 1);

            src.setText(doubleToStringWithComma(tmp));
            double cNum = Double.parseDouble(tmp);
            des.setText(doubleToStringWithComma(calculateExRate(cNum, false)));
        }
    }

    public void ceBtnOnClick(View view) {
        currencyInput1.setText(R.string._0_str);
        currencyInput2.setText(R.string._0_str);

        previousClick = INPUT_TEXTVIEW;
    }

    @SuppressLint("SetTextI18n")
    public void dotBtnOnClick(View view) {

        if(currentSelected.equals(CURRENCY_1)){
            String tmp = currencyInput1.getText().toString();
            if(tmp.contains(".")) return;
            currencyInput1.setText(tmp + ".0");
        }else{
            String tmp = currencyInput2.getText().toString();
            if(tmp.contains(".")) return;
            currencyInput2.setText(tmp + ".0");
        }

        previousClick = DOT_BUTTON;
    }

    private void inputOnClick(String selected){
        currentSelected = selected;

        if(selected.equals(CURRENCY_1)){
            currencyInput1.setTypeface(null, Typeface.BOLD);
            currencyInput2.setTypeface(null, Typeface.NORMAL);

            srcCurrency = CurrencyList.spinnerList.indexOf(spinner1.getSelectedItem().toString());
            desCurrency = CurrencyList.spinnerList.indexOf(spinner2.getSelectedItem().toString());
        }
        else{
            currencyInput2.setTypeface(null, Typeface.BOLD);
            currencyInput1.setTypeface(null, Typeface.NORMAL);

            srcCurrency = CurrencyList.spinnerList.indexOf(spinner2.getSelectedItem().toString());
            desCurrency = CurrencyList.spinnerList.indexOf(spinner1.getSelectedItem().toString());
        }

        setExRateInfor();

        previousClick = INPUT_TEXTVIEW;
    }

    @SuppressLint("SetTextI18n")
    private void setExRateInfor(){
        CurrencyUnit src = CurrencyList.cList.get(srcCurrency);
        CurrencyUnit des = CurrencyList.cList.get(desCurrency);

        exRateInfor.setText("1 "+src.getCode()+" = "+doubleToStringWithComma(calculateExRate(1, true))+" "+des.getCode());
    }

    private double round(double value, int place){
        if(place < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(place, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    private double roundDown(double value, int place){
        if(place < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(place, RoundingMode.DOWN);
        return bd.doubleValue();
    }

    private double calculateExRate(double convertedAmount, boolean serveExRateInfor){
//        Log.i("INCALC", srcCurrency+"      "+desCurrency);
        double src = round(CurrencyList.cList.get(srcCurrency).getRate(), 4);
        double des = round(CurrencyList.cList.get(desCurrency).getRate(), 4);

//        Log.i("INCALC2", src+"      "+des);

        if(serveExRateInfor){
            double res = round(convertedAmount * des / src, 4);
            if(res > 0.0001) return res;
            else return round(convertedAmount * des / src, 8);
        }

        else return round(convertedAmount * des / src, 2);
    }

    private String doubleToStringWithComma(double value){
        BigDecimal bd = BigDecimal.valueOf(value);

        //format group of 3 number characters : 123,456.789 = 123456.789
        DecimalFormat numberFormat = new DecimalFormat("#.################");
        numberFormat.setGroupingUsed(true);
        numberFormat.setGroupingSize(3);

        return numberFormat.format(Double.parseDouble(bd.stripTrailingZeros().toPlainString()));
    }
    private String doubleToStringWithComma(String strValue){
        double value = Double.parseDouble(strValue);
        value = roundDown(value, 2);
        BigDecimal bd = BigDecimal.valueOf(value);

        //format group of 3 number characters : 123,456.789 = 123456.789
        DecimalFormat numberFormat = new DecimalFormat("#.################");
        numberFormat.setGroupingUsed(true);
        numberFormat.setGroupingSize(3);

        return numberFormat.format(Double.parseDouble(bd.toPlainString()));
    }

    private String getInputValue(TextView inputTextView){
        StringBuilder value = new StringBuilder(inputTextView.getText().toString());
        String[] parts = value.toString().split(",");
        value = new StringBuilder();
        for (String part : parts) value.append(part);
        return value.toString();
    }
}