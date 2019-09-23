package boxuegu.com.boxuegu.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import boxuegu.com.boxuegu.R;

public class BootomBar {
    private View view;
    public BootomBar(Activity context){
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.bottom_bar,null);

    }

    public View getView() {
        return view;
    }
}
