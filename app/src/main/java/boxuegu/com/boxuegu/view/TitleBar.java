package boxuegu.com.boxuegu.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import boxuegu.com.boxuegu.R;

public class TitleBar {
    private View view;
    private TextView tv_title,tv_back;
    public TitleBar(Activity context,String title){
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.main_title_bar,null);
        tv_title=view.findViewById(R.id.tv_title);
        tv_title.setText(title);
        tv_back=view.findViewById(R.id.tv_back);
        tv_back.setVisibility(View.INVISIBLE);//INVISIBLE代表隐藏
    }

    public View getView() {
        return view;
    }

    public String setTitleName(String title){
        tv_title=view.findViewById(R.id.tv_title);
        tv_title.setText(title);
        tv_back=view.findViewById(R.id.tv_back);
        tv_back.setVisibility(View.INVISIBLE);//INVISIBLE代表隐藏
        return title;
    }
}
