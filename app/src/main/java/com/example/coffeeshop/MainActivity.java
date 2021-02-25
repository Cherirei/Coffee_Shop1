package com.example.coffeeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView cake_quantity;
    String add_value;
    String minus_value;
    int quantity=1;
    EditText edit_text;
    String enter_name;
    CheckBox checkBox_samosa, checkBox_cake;
    String topping;
    ConstraintLayout main;
    TextView tops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cake_quantity=findViewById(R.id.quantity);
        edit_text=findViewById(R.id.editText);
        checkBox_samosa=findViewById(R.id.checkBox);
        checkBox_cake=findViewById(R.id.checkBox2);
        main=findViewById(R.id.Main);
        tops=findViewById(R.id.textView_topping);
    }
    public  void minus(View view)
    {
        minus_value= cake_quantity.getText().toString();
        quantity= Integer.parseInt(minus_value);
        if(quantity<=1)
        {
            Toast.makeText(getApplicationContext(), "You can not order less than one Coffee", Toast.LENGTH_SHORT).show();
        }
        else {
            quantity = quantity - 1;
            String red = String.valueOf(quantity);
            cake_quantity.setText(red);
        }
    }
    public  void add(View view)
    {
        add_value=cake_quantity.getText().toString();
        quantity=Integer.parseInt(add_value);
        if (quantity>=10) {
            Toast.makeText(getApplicationContext(), "You can not order more than ten Cups of Coffee", Toast.LENGTH_SHORT).show();
        }
        else {
            quantity = quantity + 1;
            String red = String.valueOf(quantity);
            cake_quantity.setText(red);
        }
    }
    public  void order(View view)
    {
        enter_name= edit_text.getText().toString();
        Toast.makeText(getApplicationContext(), enter_name, Toast.LENGTH_SHORT).show();
        checkBoxes();
        billings(topping);
    }
    public void checkBoxes()
    {
    if (checkBox_samosa.isChecked() && checkBox_cake.isChecked())
    {topping = "Samosa and Cake";
//        Toast.makeText(getApplicationContext(), "You have checked two products", Toast.LENGTH_SHORT).show();
    }
    else if (checkBox_samosa.isChecked())
    {
        topping = "Samosa";
//        Toast.makeText(getApplicationContext(), "You have checked tamotaaa", Toast.LENGTH_SHORT).show();
    }
    else if(checkBox_cake.isChecked())
    {
        topping = "Cake";
//        Toast.makeText(getApplicationContext(), "You have checked Cake", Toast.LENGTH_SHORT).show();
    }
    else
    {
        topping="No topping";
    }
    }
    public  void  billings(String toppings)
    {
        String order;
        int coffee=quantity*15;
        int total=coffee;
        if (toppings == "Samosa and Cake")
        {
            total=total+25;
        }
        else if (toppings == "Samosa"){
            total=total+10;
        }
      else if (toppings == "Cake"){
          total =total+15;
        }
      else
        {
            total=quantity*15;
        }

      order=enter_name + " "+ "Your billing is: "+ "Ksh."+ total;
      email(order);
    }
    public  void email(String order)
    {
        String[] cars={"johkirwa17@gmail.com"};
        String[] me={"johnkirwa2017@gmail.com","ochikoalwenje@gmail.com"};
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL,cars);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order");
        intent.putExtra(Intent.EXTRA_TEXT,order);
        intent.putExtra(Intent.EXTRA_CC,me);
        if (intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuitems,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear:
                Toast.makeText(getApplicationContext(), "You have Cleared", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.teal:
                main.setBackgroundColor(getResources().getColor(R.color.teal));
            return true;
            case R.id.magenta:
                main.setBackgroundColor(getResources().getColor(R.color.magenta));
                return true;
            case R.id.cyan:
                main.setBackgroundColor(getResources().getColor(R.color.cyan));
                return true;
            case R.id.silver:
                main.setBackgroundColor(getResources().getColor(R.color.silver));
                return true;

            case R.id.hide_toppings:
                checkBox_cake.setVisibility(View.GONE);
                checkBox_samosa.setVisibility(View.GONE);
                tops.setVisibility(View.GONE);
                return true;
            case R.id.show_toppings:
                checkBox_cake.setVisibility(View.VISIBLE);
                checkBox_samosa.setVisibility(View.VISIBLE);
                tops.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}