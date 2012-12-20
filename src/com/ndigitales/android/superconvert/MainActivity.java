package com.ndigitales.android.superconvert;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

private EditText temp;

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
temp = (EditText)findViewById(R.id.et);
}

public void convertir (View v){
switch (v.getId()) {
case R.id.btn1:{
RadioButton c = (RadioButton)findViewById(R.id.r0);
RadioButton f = (RadioButton)findViewById(R.id.r1);
if (temp.getText().length() == 0){
Toast.makeText(this, "Ingrese un valor",Toast.LENGTH_LONG).show();
return;
}
float ingreso = Float.parseFloat(temp.getText().toString());
if(c.isChecked()){
temp.setText(String.valueOf(convertirC(ingreso)));
c.setChecked(false);
f.setChecked(true);

}
else{

temp.setText(String.valueOf(convertirF(ingreso)));
c.setChecked(true);
f.setChecked(false);

}
break;
}

}

}

private float convertirC(float celsi){
return ((celsi * 9) / 5) + 32;
}

private float convertirF(float fahren){
return ((fahren -32) * 5 / 9);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
getMenuInflater().inflate(R.menu.activity_main, menu);
return true;
}

}