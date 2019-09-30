package boxuegu.com.boxuegu.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import boxuegu.com.boxuegu.R;

public class CourseView {
    private View view;
    public CourseView(Activity context){
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.middle,null);//加载课程的模块中间布局

    }

    public View getView() {
        return view;
    }
}
