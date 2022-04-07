package com.wimonsiri.slideshowtimer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    ImageView iv;
    int res_image[] = {R.drawable.deosai_land, R.drawable.dudipatsar_lake,
            R.drawable.rama_lake, R.drawable.shangrila_lower_kachura_lake };
    Button startSlide;
    private Handler mHandler = new Handler( Looper.myLooper());
    int iSlide = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(res_image[iSlide]);
        startSlide = (Button) findViewById( R.id.btnStart);
        startSlide.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                iSlide = 0 ;
                iv.setImageResource(res_image[iSlide]);
                mHandler.postDelayed( mUpdateTimeTask , 2000);
                startSlide.setEnabled(false);
            }
        });
    }
    private Runnable mUpdateTimeTask = new Runnable () {
        public void run() {
            if (iSlide < 3) {
                iSlide ++;
                iv.setImageResource(res_image[iSlide]);
                mHandler.postDelayed(this, 2000);
            }
            else {
                iSlide = 0;
                startSlide.setEnabled(true);
                iv.setImageResource(res_image[iSlide]);
            }
        }
    };
}