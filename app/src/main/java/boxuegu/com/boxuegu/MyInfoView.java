package boxuegu.com.boxuegu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyInfoView extends AppCompatActivity {

    private LinearLayout iv_history,iv_setting;
    private TextView tv_user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_view_myinfo);
        findById();

        iv_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        iv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv_user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void findById(){
        iv_history=(LinearLayout)findViewById(R.id.iv_history);
        iv_setting=(LinearLayout)findViewById(R.id.iv_setting);
        tv_user_name=(TextView)findViewById(R.id.tv_user_name);
    }
}
