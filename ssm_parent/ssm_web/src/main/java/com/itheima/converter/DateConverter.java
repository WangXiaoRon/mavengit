package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    public Date convert(String source) {
        try {
            System.out.println("来到我们的转化器里面了：" + source);
            SimpleDateFormat sdf=null;
            if(source.contains("-")){
                sdf = new SimpleDateFormat("yyyy-MM-dd");

            }else if(source.contains("/")){
                sdf = new SimpleDateFormat("yyyy/MM/dd");

            }
            Date date = sdf.parse(source);
            return date;
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return null;
    }
}
