package com.imooc.ad.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @ClassName SignatureUtil
 * @description:  申通快递工具类
 * @author: qsong
 * @create: 2020-11-26 16:45
 * @Version 1.0
 **/
public class SignatureUtil {

    private SignatureUtil() {
        throw new IllegalStateException("SignatureUtil class");
    }

    public static String getSignature(String content, String secretKey) {
        String text = content + secretKey;
        byte[] md5 = DigestUtils.md5(text);
        return Base64.encodeBase64String(md5);
    }
}
