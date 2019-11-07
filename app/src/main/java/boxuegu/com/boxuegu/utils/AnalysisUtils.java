package boxuegu.com.boxuegu.utils;

import android.util.Xml;

import java.util.List;

import boxuegu.com.boxuegu.bean.ExercisesDetailBean;
import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;

public class AnalysisUtils {

    static public List<ExercisesDetailBean> getExercisesInfos(InputStream inputStream)throws Exception{
        //解析inputSteream所对应的文件，返回解析选择题集合，P153
        XmlPullParser parse= Xml.newPullParser();//获取或生成一个解析器对象
        List<ExercisesDetailBean> beans=null;
        ExercisesDetailBean bean=null;
        parse.setInput(inputStream,"utf-8");
        int type=parse.getEventType();
        while (type!=XmlPullParser.END_DOCUMENT){
            //分析文件里面的内容，为元素的属性赋值
            switch (type){
                case XmlPullParser.START_TAG: {
                    if ("infos".equals(parse.getName())) {
                        beans = new ArrayList<ExercisesDetailBean>();
                    }else if ("exercises".equals(parse.getName())){//表示读取到的是exercises
                        bean=new ExercisesDetailBean();
                        bean.id=Integer.parseInt(parse.getAttributeValue(0));
                    }else if ("subject".equals(parse.getName())){
                        bean.subject=parse.nextText();//2个作用，指针后移，读取开始标签对应的内容
                    }else if ("a".equals(parse.getName())){
                        bean.a=parse.nextText();
                    }else if ("b".equals(parse.getName())){
                        bean.b=parse.nextText();
                    }else if ("c".equals(parse.getName())){
                        bean.c=parse.nextText();
                    }else if ("d".equals(parse.getName())){
                        bean.d=parse.nextText();
                    }else if ("answer".equals(parse.getName())){
                        bean.answer=Integer.parseInt(parse.nextText());
                    }
                    break;
                }case XmlPullParser.END_TAG:{
                    if ("exercises".equals(parse.getName())){
                        bean.selected=0;//0代表用户没有选择答案,选择了就变成1
                        beans.add(bean);
                        bean=null;
                    }
                    break;
                }
            }

            //往下一行移动并且读取
            type=parse.next();
        }
        return beans;
    }
}
