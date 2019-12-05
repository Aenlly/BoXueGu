package boxuegu.com.boxuegu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import boxuegu.com.boxuegu.ExercisesDetailActivity;
import boxuegu.com.boxuegu.R;
import boxuegu.com.boxuegu.bean.ExercisesBean;
import boxuegu.com.boxuegu.bean.ExercisesDetailBean;

public class ExercisesDetailAdapter extends BaseAdapter {
    private List<ExercisesDetailBean> beans;//题目集合,数据源
    private Context context;//上下文
    private int ivId[]={R.drawable.exercises_a,R.drawable.exercises_b,R.drawable.exercises_c,R.drawable.exercises_d};

    public ExercisesDetailAdapter(List<ExercisesDetailBean> beans,Context context) {
        this.context=context;
        this.beans=beans;
    }

    @Override
    public int getCount() {
        if (beans==null) return 0;
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        if (beans==null) return null;
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //listview通过执行这个方法来显示数据到屏幕上，执行一次就显示一行
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.exercises_detail_list_item,null);
            //加载一个选择题的行布局文件，生成行view控件
            viewHolder=new ViewHolder();
            viewHolder.tv_subject=convertView.findViewById(R.id.tv_subject);
            viewHolder.tv_a=convertView.findViewById(R.id.tv_a);
            viewHolder.tv_b=convertView.findViewById(R.id.tv_b);
            viewHolder.tv_c=convertView.findViewById(R.id.tv_c);
            viewHolder.tv_d=convertView.findViewById(R.id.tv_d);
            viewHolder.iv[0]=convertView.findViewById(R.id.iv_a);
            viewHolder.iv[1]=convertView.findViewById(R.id.iv_b);
            viewHolder.iv[2]=convertView.findViewById(R.id.iv_c);
            viewHolder.iv[3]=convertView.findViewById(R.id.iv_d);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
            if(beans.get(position).selected==0){//表示新滚入的行，用户曾经没有选择过，行控件是利用滚走的
                for(int i=0;i<4;i++){
                    viewHolder.iv[i].setImageResource(ivId[i]);
                    viewHolder.iv[i].setEnabled(true);
                }
            }else {//表示新滚入的行，用户曾经没有选择过，要读取曾经选择过的信息，显示到刚滚走的行控件里
                setRightError(viewHolder.iv,beans.get(position).answer,beans.get(position).selected);
            }

        }
        viewHolder.tv_subject.setText(beans.get(position).subject);
        viewHolder.tv_a.setText(beans.get(position).a);
        viewHolder.tv_b.setText(beans.get(position).b);
        viewHolder.tv_c.setText(beans.get(position).c);
        viewHolder.tv_d.setText(beans.get(position).d);

        final ViewHolder vh=viewHolder;

        //写上选择题作答的代码：用户单击选择题这一行响应事件代码
        viewHolder.iv[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beans.get(position).selected=ExercisesDetailBean.A;
                setRightError(vh.iv,beans.get(position).answer,ExercisesDetailBean.A);
            }
        });

        viewHolder.iv[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beans.get(position).selected=ExercisesDetailBean.B;
                setRightError(vh.iv,beans.get(position).answer,ExercisesDetailBean.B);
            }
        });

        viewHolder.iv[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beans.get(position).selected=ExercisesDetailBean.C;
                setRightError(vh.iv,beans.get(position).answer,ExercisesDetailBean.C);
            }
        });

        viewHolder.iv[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beans.get(position).selected=ExercisesDetailBean.D;
                setRightError(vh.iv,beans.get(position).answer,ExercisesDetailBean.D);
            }
        });

        return convertView;
    }

    class ViewHolder{
        public  TextView tv_subject,tv_b,tv_c,tv_d,tv_a;
        public ImageView[] iv=new ImageView[4];
    }

    private void setRightError(ImageView[] iv,int answer,int selected){
        for(int i=0;i<4;i++){
            iv[i].setImageResource(ivId[i]);
        }
        if(answer==selected){//答案是否正确
            iv[selected-1].setImageResource(R.drawable.exercises_right_icon);
        }else {
            iv[selected-1].setImageResource(R.drawable.exercises_error_icon);
            iv[answer-1].setImageResource(R.drawable.exercises_right_icon);
        }
        for(int i=0;i<4;i++){
            iv[i].setEnabled(false);
        }
    }
}