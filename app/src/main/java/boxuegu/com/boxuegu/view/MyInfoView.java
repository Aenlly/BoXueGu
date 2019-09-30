package boxuegu.com.boxuegu.view;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import boxuegu.com.boxuegu.MainActivity;
import boxuegu.com.boxuegu.R;

public class MyInfoView {
    private View view;
    public MyInfoView(Activity context){
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.middle,null);//加载我的模块中间布局

    }

    public View getView() {
        return view;
    }

}