package com.example.smartirr;

import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
 TextView text; //motor on off status textf
 ToggleButton btn;  //motor on off button
 Button refreshButton; //refresh button
    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.textView);
        btn=(ToggleButton)findViewById(R.id.toggleButton);
        refreshButton =(Button)findViewById(R.id.refreshButton);
        text2=(TextView)findViewById(R.id.textView3);

        //to check if the bluetooth adapter is present or not
        BluetoothAdapter bluetoothAdapter= BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(),"Device doesn't Support Bluetooth",Toast.LENGTH_SHORT).show();
        }


        //reading the sensor data

        // THIS CODE IS COMMENTED BECAUSE WITHOUT THE BLUETOOTH MODULE CONNECTION, IT WILL SHOW ERROR AND THE CODE WON'T WORK.
//
//        int byteCount = inputStream.available();
//        if(byteCount > 0)
//        {
//            byte[] rawBytes = new byte[byteCount];
//            inputStream.read(rawBytes);
//            final String string=new String(rawBytes,"UTF-8");
//            handler.post(new Runnable() {
//                public void run()
//                {
//                    textView.append(string);
//                }
//            });
//        }


        //   To send data, pass the String to the OutputStream.

        //THIS CODE IS COMMENTED BECAUSE WITHOUT THE BLUETOOTH MODULE CONNECTION, IT WILL SHOW ERROR AND THE CODE WON'T WORK.


        //outputStream.write(string.getBytes());

    }





    public void checked(View view)
    {
      boolean check = ((ToggleButton)view).isChecked();
      if(check==true)
      {
          text.setText("Motor is turned on!!" +
                  "Click to turn off the motor");

      }
      else
          text.setText("Click to turn on the motor");
    }
  int count=0;
    public void refresh(View view)
    {
        if(count==2)
        {
            count=0;
        }
        ++count;
       switch (count)
       {
           case 1:
               text2.setText("The moisture level is 46");
               AlertDialog .Builder builder = new AlertDialog.Builder(MainActivity.this);
               builder.setCancelable(true);
               builder.setTitle("Alert!");
               builder.setMessage("Moisture level is low, turn on motor.");
               builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });
               builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                   }
               });
               builder.show();
               break;
           case 2:
               text2.setText("The moisture level is 75");
               AlertDialog .Builder build = new AlertDialog.Builder(MainActivity.this);
               build.setCancelable(true);
               build.setTitle("No worries!");
               build.setMessage("Moisture level is above the set limit, your plants don't need water!");
               build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });
               build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                   }
               });
               build.show();
               break;
           default:
               break;


       }

    }
}
