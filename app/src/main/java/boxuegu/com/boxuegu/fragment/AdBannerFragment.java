package boxuegu.com.boxuegu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import boxuegu.com.boxuegu.R;

public class AdBannerFragment extends Fragment {
    private ImageView iv;
    private String ab;//图片的名字
    //图片名字压入Buudle对象，再在onCreat中取出

    public static AdBannerFragment newInstance(Bundle bundle){
        AdBannerFragment af=new AdBannerFragment();
        af.setArguments(bundle);
        return af;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arg=getArguments();//取出参数
        ab =arg.getString("ab");
    }

    @Override
    public void onResume() {//界面可见时执行，添加图片
        super.onResume();
        if(ab.equals("banner_1")){
            iv.setImageResource(R.drawable.banner_1);
        }else if(ab.equals("banner_2")){
            iv.setImageResource(R.drawable.banner_2);
        }else if(ab.equals("banner_3")){
            iv.setImageResource(R.drawable.banner_3);
        }
    }

    @Nullable
    @Override
    //onCreate后自动调用该方法，返回对象的view
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        iv=new ImageView(getActivity());
        //ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        //iv.setLayoutParams(lp);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        return iv;
    }
}
