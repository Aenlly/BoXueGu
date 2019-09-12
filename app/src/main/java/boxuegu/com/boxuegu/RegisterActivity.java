package boxuegu.com.boxuegu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViewById();
        tv_title.setText("注册");
    }


    public void findViewById(){
        tv_title=findViewById(R.id.tv_title);
    }
}
