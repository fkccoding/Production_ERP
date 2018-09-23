package com.erp.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Converter<S, T>
 *     S:页面传过来的类型
 *     T:转换后的类型
 */
public class DateConvert implements Converter<String, Date> {


    @Override
    public Date convert(String s) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
