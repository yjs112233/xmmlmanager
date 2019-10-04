package yjs.xmml.xmmlmanager.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsPhone {

    public  static boolean cheak(String phone){
            String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
            if (phone.length() != 11) {
                return false;
            } else {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(phone);
                boolean isMatch = m.matches();
                return isMatch;
            }
        }
    //测试
    public static void main(String[] args) {
        String phone="19025425632";
        System.out.println(cheak(phone));
    }
}
