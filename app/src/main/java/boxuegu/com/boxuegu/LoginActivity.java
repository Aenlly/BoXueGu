package boxuegu.com.boxuegu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView tv_title;
    private EditText et_user_name,et_pwd;
    private TextView tv_regist;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private void init(){
        tv_title=(TextView)findViewById(R.id.tv_title);
        tv_title.setText("登录");

        tv_regist=(TextView)findViewById(R.id.tv_register);

        tv_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回跳
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent,111);
            }
        });

        et_user_name=(EditText)findViewById(R.id.et_user_name);
        et_pwd=(EditText)findViewById(R.id.et_pwd);

        btn_login=(Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_user_name==null){
                    Toast.makeText(LoginActivity.this,"请输入用户名",Toast.LENGTH_LONG);
                }else if(et_pwd==null){
                    Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_LONG);
                }
            }
        });
    }
}
