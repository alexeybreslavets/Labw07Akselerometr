package com.example.user.labw07akselerometr;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    Button sbros;
    TextView xyz, XYZ;
    SensorManager misha;
    Sensor sasha;
    float x, y, z, X = 0, Y = 0, Z = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xyz = (TextView) findViewById(R.id.xyz);
        XYZ = (TextView) findViewById(R.id.XYZ);

        sbros = (Button) findViewById(R.id.sbros);

        misha = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sasha = misha.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sbros.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                XYZ.setText("");
                X = 0;
                Y = 0;
                Z = 0;
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0]; y = event.values[1]; z = event.values[2];
        xyz.setText("x=" + x + " y=" + y + " z=" + z);
        if (x > X){
            X = x;
            XYZ.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if (y > Y){
            Y = y;
            XYZ.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if (z > Z){
            Z = z;
            XYZ.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if ((x > X) && (y > Y)){
            X = x;
            Y = y;
            XYZ.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if ((x > X) && (z > Z)){
            X = x;
            Z = z;
            XYZ.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if ((y > Y) && (z > Z)){
            Y = y;
            Z = z;
            XYZ.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if ((x > X) && (y > Y) && (z > Z)){
            X = x;
            Y = y;
            Z = z;
            XYZ.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if ((x < X) && (y < Y) && (z < Z)){
            XYZ.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        misha.registerListener(this, sasha, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
