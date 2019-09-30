package boxuegu.com.boxuegu.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import boxuegu.com.boxuegu.R;

public class ExercisesView {
    private View view;
    public ExercisesView(Activity context){
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.middle,null);//加载习题的模块中间布局

    }

    public View getView() {
        return view;
    }
}
