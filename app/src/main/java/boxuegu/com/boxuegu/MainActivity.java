package boxuegu.com.boxuegu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

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
}
