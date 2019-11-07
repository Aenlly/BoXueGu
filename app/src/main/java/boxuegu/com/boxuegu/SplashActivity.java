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
import boxuegu.com.boxuegu.R;
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView textView=(TextView) findViewById(R.id.tv_version);

        PackageInfo packageInfo=null;

        PackageManager packageManager=getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo("boxuegu.com.boxuegu3", 0);
            textView.setText("V "+packageInfo.versionName);
        }catch (Exception e){
            textView.setText("V ");
            e.printStackTrace();
        }

        Timer timer=new Timer();

        TimerTask task=new TimerTask() {
            @Override
            public void run() {//第42-44行过3000毫秒后执行的代码
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        };

//        timer.schedule(代码，时间);表示当执行这一行时，再过参数2时间，执行参数1代码
        timer.schedule(task,3000);
        
    }
}
