package boxuegu.com.boxuegu;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }
    private TextView textView;
    private int i=3;
    private void init(){
        textView= findViewById(R.id.text_v);

        //获取版本号
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
            textView.setText("V"+info.versionName);
        }catch (PackageManager.NameNotFoundException e){

        }


        Timer timer=new Timer();
        final TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        };
        timer.schedule(task,3000);
    }
}
