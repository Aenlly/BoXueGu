package boxuegu.com.boxuegu;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import boxuegu.com.boxuegu.R;
import boxuegu.com.boxuegu.utils.ReadWriteSP;
import boxuegu.com.boxuegu.view.BottomBar;

public class MainActivity extends AppCompatActivity {
    private BottomBar bottomBar;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //从这个活动跳出去的，回跳回来执行该方法
        if(requestCode==8888){
            if(data!=null){
                //将用户名显示到我界面的图标下面
                String name=data.getStringExtra("userName");
                bottomBar.setLoginStatus(name);
            }
        }
        if(requestCode==666&&resultCode==6666){
            //表示从设置界面的退出登录按钮回跳回来
//            我的子界面图标下面的文字要改为“点击登录”，这一步在主界面接收回跳的事件代码中执行
            bottomBar.setLoginStatus("点击登录");
        }
    }

    @Override
    protected void onDestroy() {
        if(ReadWriteSP.readLoginStatus(this)){
            ReadWriteSP.clearLoginStatus(this);
        }
        System.exit(0);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //一般用于activity加载布局文件

        bottomBar=new BottomBar(this);
        LinearLayout bottomLoc=findViewById(R.id.mian_bottom_bar);
        bottomLoc.addView(bottomBar.getView());

    }
    long t0=0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK&&event.getAction()==KeyEvent.ACTION_DOWN){
            long t1=System.currentTimeMillis();
            if(t1-t0>2000){
                Toast.makeText(this,"再次单击返回键退出app",Toast.LENGTH_LONG).show();
                t0=t1;
            }else{
                //退出app
                this.finish();
                //清除登陆状态
                if(ReadWriteSP.readLoginStatus(this)){
                    ReadWriteSP.clearLoginStatus(this);
                }
                System.exit(0);
            }
            return true;//表示本次返回按钮处理完毕，不需要调用父亲的方法来处理
        }
        return super.onKeyDown(keyCode, event);
    }
}
