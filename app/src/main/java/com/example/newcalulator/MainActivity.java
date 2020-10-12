package com.example.newcalulator;

import androidx.appcompat.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private EditText edtNumber;
     private TextView tvResult;
     private Button btnNumber0;
     private Button btnNumber1;
     private Button btnNumber2;
     private Button btnNumber3;
     private Button btnNumber4;
     private Button btnNumber5;
     private Button btnNumber6;
     private Button btnNumber7;
     private Button btnNumber8;
     private Button btnNumber9;

     private Button btnCong;
     private Button btnTru;
     private Button btnNhan;
     private Button btnChia;

     private Button btnPoint;
     private Button btnResult;
     private Button btnCe;
     private Button btnC;
     private Button btnBs;
     private Button btnDoidau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWigdet();
    }

    public void initWigdet(){
         edtNumber=(EditText)findViewById(R.id.edt_input);
         tvResult=(EditText)findViewById(R.id.tv_result);
         btnNumber0= (Button)findViewById(R.id.btnNumber0);
         btnNumber1= (Button)findViewById(R.id.btnNumber1);
         btnNumber2= (Button)findViewById((R.id.btnNumber2);
         btnNumber3= (Button)findViewById((R.id.btnNumber3);
         btnNumber4= (Button)findViewById((R.id.btnNumber4);
         btnNumber5= (Button)findViewById((R.id.btnNumber5);
         btnNumber6= (Button)findViewById((R.id.btnNumber6);
         btnNumber7= (Button)findViewById((R.id.btnNumber7);
         btnNumber8= (Button)findViewById((R.id.btnNumber8);
         btnNumber9= (Button)findViewById((R.id.btnNumber9);

         btnCong=(Button)findViewById(R.id.btnCong);
         btnTru =(Button)findViewById(R.id.btnTru);
         btnNhan=(Button)findViewById(R.id.btnNhan);
         btnChia=(Button)findViewById(R.id.btnChia);

         btnPoint=(Button)findViewById(R.id.btnPoint);
         btnResult=(Button)findViewById(R.id.btnResult);
         btnCe=(Button)findViewById(R.id.btnCe);
         btnC=(Button)findViewById(R.id.btnC);
         btnBs=(Button)findViewById(R.id.btnBs);
         btnDoidau=(Button)findViewById(R.id.btnDoidau);

    }
    public void setEventClickView(){
        btnNumber0.OnClickListener(this);
        btnNumber1.OnClickListener(this);
        btnNumber2.OnClickListener(this);
         btnNumber3.OnClickListener(this);
         btnNumber4.OnClickListener(this);
         btnNumber5.OnClickListener(this);
         btnNumber6.OnClickListener(this);
         btnNumber7.OnClickListener(this);
         btnNumber8.OnClickListener(this);
         btnNumber9.OnClickListener(this);

         btnCong.OnClickListener(this);
         btnTru.OnClickListener(this);
         btnNhan.OnClickListener(this);
         btnChia.OnClickListener(this);

         btnPoint.OnClickListener(this);
         btnResult.OnClickListener(this);
         btnCe.OnClickListener(this);
         btnC.OnClickListener(this);
         btnBs.OnClickListener(this);
         btnDoidau.OnClickListener(this);



    }
    @Override
    public void onClick(View v){
      switch (v.getId()){
                case R.id.btnNumber0:
                     edtNumber.append("0");
                break;
                case R.id.btnNumber1:
                     edtNumber.append("1");
                break;
                case R.id.btnNumber2:
                     edtNumber.append("2");
                break;
                case R.id.btnNumber3:
                     edtNumber.append("3");
                break;
                case R.id.btnNumber4:
                     edtNumber.append("4");
                break;
                case R.id.btnNumber5:
                     edtNumber.append("5");
                break;
                case R.id.btnNumber6:
                     edtNumber.append("6");
                break;
                case R.id.btnNumber7:
                     edtNumber.append("7");
                break;
                case R.id.btnNumber8:
                     edtNumber.append("8");
                break;
                case R.id.btnNumber9:
                     edtNumber.append("9");
                break;
                case R.id.btnCong:
                     edtNumber.append("+");
                break;
                case R.id.btnTru:
                     edtNumber.append("-");
                break;
                case R.id.btnNhan:
                     edtNumber.append("x");
                break;
                case R.id.btnChia:
                     edtNumber.append("/");
                break;
                case R.id.btnPoint:
                    edtNumber.append(".");
                break;
                case R.id.btnCe:
                    edtNumber.setText("");
                    tvResult.setText("");
                break;
                case R.id.btnC:
                    edtNumber.setText("");

                break;
                case R.id.btnBs:
                    BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtNumber,true);
                    textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
                case R.id.btnDoidau:
                    break;
          case R.id.btnResult:
              DecimalFormat df = new DecimalFormat("###.#######");
              double result = 0;
              addOperation(edtNumber.getText().toString());
              addNumber(edtNumber.getText().toString());
              if(arrOperation.size()>=arrNumber.size() ||arrOperation.size()<1){
                  tvResult.setText("Lỗi định dạng");
              }else {
                  for (int i = 0; i < (arrNumber.size() - 1); i++) {
                      switch (arrOperation.get(i)) {
                          case "+":
                              if (i == 0) {
                                  result = arrNumber.get(i) + arrNumber.get(i + 1);
                              } else {
                                  result = result + arrNumber.get(i + 1);
                              }
                              break;
                          case "-":
                              if (i == 0) {
                                  result = arrNumber.get(i) - arrNumber.get(i + 1);
                              } else {
                                  result = result - arrNumber.get(i + 1);
                              }
                              break;
                          case "*":
                              if (i == 0) {
                                  result = arrNumber.get(i) * arrNumber.get(i + 1);
                              } else {
                                  result = result * arrNumber.get(i + 1);
                              }
                              break;
                          case "/":
                              if (i == 0) {
                                  result = arrNumber.get(i) / arrNumber.get(i + 1);
                              } else {
                                  result = result / arrNumber.get(i + 1);
                              }
                              break;
                          default:
                              break;
                      }
                  }
                  tvResult.setText(df.format(result) + "");
              }

      }

    }
    public ArrayList<String> arrOperation;
    public ArrayList<Double> arrNumber;

 int addOperation(String input) {
        arrOperation = new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

}