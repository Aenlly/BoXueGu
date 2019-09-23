package boxuegu.com.boxuegu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import boxuegu.com.boxuegu.utils.MD5Utils;

public class RegisterActivity extends AppCompatActivity {

    private TextView tv_title;//标题的显示
    private TextView tv_back;//返回键
    private Button btn_regist;//注册键
    private EditText et_user_name,et_pwd,et_pwd_again;//用户名、密码、重复密码输入控件
    private String userName,pwd,pwd_again;//获取用户名、密码、重复密码的值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        findViewById();

    }


    public void findViewById(){
        tv_title=(TextView)findViewById(R.id.tv_title);
        tv_title.setText("注册");

        tv_back=(TextView)findViewById(R.id.tv_back);

        btn_regist=(Button) findViewById(R.id.btn_register);

        et_user_name=(EditText) findViewById(R.id.et_user);
        et_pwd=(EditText)findViewById(R.id.et_pwd);
        et_pwd_again=(EditText)findViewById(R.id.et_pwd_again);

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.this.finish();
            }
        });

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getEditString();
                if (TextUtils.isEmpty(userName)){
                    Toast.makeText(RegisterActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();
                    return;
                }else if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(RegisterActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }else if (TextUtils.isEmpty(pwd_again)){
                    Toast.makeText(RegisterActivity.this,"请再次输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }else if (!pwd.equals(pwd_again)){
                    Toast.makeText(RegisterActivity.this,"输入两次的密码不一样",Toast.LENGTH_SHORT).show();
                    return;
                }else if (isExistUserName(userName)){
                    Toast.makeText(RegisterActivity.this,"此账号名已经存在",Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();

                    String md5pwd= MD5Utils.md5(pwd);
                    SharedPreferences sharedPreferences=getSharedPreferences("loginInfo",MODE_PRIVATE);

                    SharedPreferences.Editor editor=sharedPreferences.edit();

                    editor.putString(userName,md5pwd);
                    editor.commit();

                    Intent intent=new Intent();
                    intent.putExtra("userName",userName);
                    intent.putExtra("pwd",pwd);
                }
            }
        });
    }

    private void getEditString(){
        userName=et_user_name.getText().toString().trim();
        pwd=et_pwd.getText().toString().trim();
        pwd_again=et_pwd_again.getText().toString().trim();
    }

    private boolean isExistUserName(String username){
        boolean has_userName=false;
        SharedPreferences sp=getSharedPreferences("loginfo",MODE_PRIVATE);
        String spPwd=sp.getString(username,"");
        if(!TextUtils.isEmpty(spPwd)){
            has_userName=true;
        }
        return has_userName;
    }

//    private void saveRegisterInfo(String username,String pwd){
//        String md5pwd= MD5Utils.md5(pwd);
//        SharedPreferences sharedPreferences=getSharedPreferences("loginInfo",MODE_PRIVATE);
//
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//
//        editor.putString(username,md5pwd);
//        editor.commit();
//    }
}
