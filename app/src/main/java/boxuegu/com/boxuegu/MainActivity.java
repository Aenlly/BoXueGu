package boxuegu.com.boxuegu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //一般用于activity加载布局文件

        BottomBar bottomBar=new BottomBar(this);
        LinearLayout bottomLoc=findViewById(R.id.main_bottom_bar);
        bottomLoc.addView(bottomBar.getView());

    }

    protected long exitTime;//记录第一次按退出键的时间
    public boolean onKeyDwon(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK&&event.getAction()==KeyEvent.ACTION_DOWN){
            long exitTime2=System.currentTimeMillis();//记录第二次按退出键的时间
            if ((exitTime2-exitTime)>2000){
                Toast.makeText(MainActivity.this,"再按一次退出应用",Toast.LENGTH_LONG).show();
                exitTime=exitTime2;
            }else{
                MainActivity.this.finish();
                //退出得记录登录信息在SP文件中，避免再次登录
            }
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
