package com.example.myandroid.jni_opcv;

import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private Sensor mGyro;
    private TextView values;
    private SensorManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        values = (TextView)findViewById(R.id.gyro_text);
        values.setText("start2");
        manager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mGyro = manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        manager.registerListener(this, mGyro, SensorManager.SENSOR_DELAY_FASTEST);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        //if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
        String str =
                            "x:" + event.values[0]
                        + "\ny:" + event.values[1]
                        + "\nz:" + event.values[2]
                        + "\ntime:" + event.timestamp;

        values.setText(str);
        //}
    }

}
/*
    @Override
    public void onPreviewFrame(byte[] arg0, Camera arg1)
    {

       // At preview mode, the frame data will push to here.
       if (imageFormat == ImageFormat.NV21)
           {
          //We only accept the NV21(YUV420) format.
          if ( !bProcessing )
          {
             FrameData = arg0;
             mHandler.post(DoImageProcessing);
          }
           }

    }
	//
	// Native JNI
	//
    public native boolean ImageProcessing(int width, int height,
    		byte[] NV21FrameData, int [] pixels);
    static
    {
        System.loadLibrary("ImageProcessing");
    }

    private Runnable DoImageProcessing = new Runnable()
    {
        public void run()
        {

    		Log.i("MyRealTimeImageProcessing", "DoImageProcessing():");
        	bProcessing = true;
			ImageProcessing(PreviewSizeWidth, PreviewSizeHeight, FrameData, pixels);

			bitmap.setPixels(pixels, 0, PreviewSizeWidth, 0, 0, PreviewSizeWidth, PreviewSizeHeight);
			MyCameraPreview.setImageBitmap(bitmap);
			bProcessing = false;

        }
    };
 */