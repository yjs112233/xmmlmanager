package yjs.xmml.xmmlmanager.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public static String parse(Date date){
        SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return df.format(date);
    }
}
