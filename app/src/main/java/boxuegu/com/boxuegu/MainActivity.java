package boxuegu.com.boxuegu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_kechen,btn_xiti,btn_w;
        final TextView tv_check;
        final LinearLayout layout_new;
        btn_kechen=findViewById(R.id.btn_kechen);
        btn_xiti=findViewById(R.id.btn_xiti);
        btn_w=findViewById(R.id.btn_w);
        layout_new=findViewById(R.id.layout_new);

        btn_kechen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    ChildView1 childView1=new ChildView1(MainActivity.this,"博学谷课程");
                    layout_new.addView(childView1.getView());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btn_xiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    ChildView1 childView1=new ChildView1(MainActivity.this,"博学谷习题");
                    layout_new.addView(childView1.getView());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btn_w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    ChildView1 childView1=new ChildView1(MainActivity.this,null);
                    layout_new.addView(childView1.getView());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}
