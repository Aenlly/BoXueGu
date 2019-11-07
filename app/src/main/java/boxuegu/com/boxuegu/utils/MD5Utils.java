package boxuegu.com.boxuegu.utils;

import java.security.MessageDigest;

public class MD5Utils {
    //用一个静态方法来进行加密
    public static String md5(String text){
        MessageDigest digest=null;
        StringBuilder str=new StringBuilder();

        try {
            digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(text.getBytes());
//            str = result.toString();
            for(byte b:result){
                int number=b&0xff;
                String hex=Integer.toHexString(number);//将这个数字转换16进制的字符串返回
                if(hex.length()==1){
                    hex="0"+hex;
                }
                str.append(hex);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str.toString();
    }
}
