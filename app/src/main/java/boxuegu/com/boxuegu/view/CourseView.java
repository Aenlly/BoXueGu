package boxuegu.com.boxuegu.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import boxuegu.com.boxuegu.R;

public class CourseView{
    private View view;
    public CourseView(Activity context){
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.main_view_course,null);
        //下面可以寻找view里面的控件，设置相关事件代码
    }

    public View getView() {
        return view;
    }
}
