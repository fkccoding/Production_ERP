package com.erp.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat implements Converter<String,Date> {
    @Override
    public Date convert(String s) {

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse=null;
        try {
            parse = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return parse;
    }

}
