package com.imooc.ad.utils;

/**
 * @ClassName FileUtils
 * @description:
 * @author: qsong
 * @create: 2020-11-20 11:36
 * @Version 1.0
 **/


import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @ClassName FileUtil
 * @description: 文件工具
 * @author: qsong
 * @create: 2020-11-12 11:32
 * @Version 1.0
 **/
public class FileUtil {

    /**
     * InputStream转byte
     * @param input
     * @return
     * @throws IOException
     */
    public static byte[] inputStreamToByteArray(InputStream input)
            throws IOException{
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        copy(input, output);
        return output.toByteArray();
    }
    private static int copy(InputStream input, OutputStream output)throws IOException{
        byte[] buffer = new byte[4096];
        long count = 0L;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        if (count > 2147483647L) {
            return -1;
        }
        return (int)count;
    }

    /**
     * 生成文件夹
     * @param
     */
    public static Boolean createFolder(String path){

        //生成文件目录
        File dirFile  = new File( path);
        if (!(dirFile.exists()) && !(dirFile.isDirectory())){
            dirFile.mkdirs();
            return true;
        }
        return false;
    }
    /**
     * 去除字符串中的空格、回车、换行符、制表符
     * @param
     * @return
     */
    public static String replaceBlank(String content) {
        String dest = "";
        if (content != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(content);
            dest = m.replaceAll("");
        }
        return dest;
    }
    /**
     * 删除目录
     * @param
     */
    public static Boolean removeDirectory(File dir){
        Boolean state = null;
        if(dir.isDirectory()){
            state = org.apache.commons.io.FileUtils.deleteQuietly(dir);
            if(state == false){
                //清空内容
                String[] extensions = null;//后缀名{"doc", "pdf"}
                boolean recursive = true;//是否递归

                Collection<File> files = FileUtils.listFiles(dir, extensions, recursive);
                // 迭代输出
                for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
                    File file = iterator.next();
                    if(!file.isHidden()){//不是隐蔽文件
                        //清空内容
                        try {
                            FileUtils.writeStringToFile(file, "", "UTF-8");
                            state = file.delete();

                        } catch (IOException e) {

                        }
                    }
                }
            }
        }
        return state;
    }
    /**
     * @Author qsong
     * @Description 获取文件的大小
     * @Date 下午1:48 2020/11/20
     * @Param
     * @return 返回KB大小
     **/
    public static  Long getFileSize(File file){
        if(file.exists()&&file.isFile()){
            return file.length()/1024;
        }
        return -1L;
    }
}
