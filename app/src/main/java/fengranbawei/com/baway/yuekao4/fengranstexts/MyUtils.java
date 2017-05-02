package fengranbawei.com.baway.yuekao4.fengranstexts;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/5/2.
 */
public class MyUtils {
    public static String getstr(InputStream inputStream){
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        byte[]  buffer=new byte[1024];
        int len=0;
        try {
            while((len=inputStream.read(buffer))!=-1){
                out.write(buffer,0,len);

            }
            return  out.toString("utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
