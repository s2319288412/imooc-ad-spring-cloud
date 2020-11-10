package com.imooc.ad.utils;

import com.imooc.ad.exception.AdException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @ClassName CommonUtils
 * @description:工具类
 * @author: qsong
 * @create: 2020-11-10 16:46
 * @Version 1.0
 **/
public class  CommonUtils {
    private static String[] parsePatterns={
            "yyyy-MM-dd","yyyy/MM/dd","yyyy.MM.dd"
    };

    //自定义一个token并大写
    public static String md5(String value){
        return DigestUtils.md5Hex(value).toUpperCase();
    }
    //字符串转Date类型
    public static Date parseStringDate(String dateString)throws AdException {
        try {
            return DateUtils.parseDate(dateString,parsePatterns);
        } catch (ParseException e) {
            throw new AdException(e.getMessage());
        }
    }

}
