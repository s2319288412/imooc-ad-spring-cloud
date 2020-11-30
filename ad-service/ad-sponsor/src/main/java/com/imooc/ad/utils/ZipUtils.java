package com.imooc.ad.utils;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * @author qsong
 * @version 1.0
 * @date
 */
/**
 * 将文件夹下面的文件
 * 打包成zip压缩文件
 * @author Saffi
 * @date 2017-10-16
 */
public final class ZipUtils {

    private ZipUtils(){}

    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     * @param sourceFilePath :待压缩的文件路径
     * @param zipFilePath :压缩后存放路径
     * @param fileName :压缩后文件的名称
     * @return
     * @throws IOException
     *
     * 注：不支持压缩文件夹下有目录
     */
    public static boolean fileToZip(String sourceFilePath,String zipFilePath,String fileName) throws IOException{
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if(sourceFile.exists() == false){
            System.out.println("待压缩的文件目录："+sourceFilePath+"不存在.");
        }else{
            try {
                File zipFile = new File(zipFilePath + "/" + fileName +".zip");
                if(zipFile.exists()){

                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName +".zip" +"打包文件.");
                }else{
                    File[] sourceFiles = sourceFile.listFiles();
                    if(null == sourceFiles || sourceFiles.length<1){
                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                    }else{

                        fos = new FileOutputStream(zipFile);
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
                        byte[] bufs = new byte[1024*10];
                        for(int i=0;i<sourceFiles.length;i++){
                            //创建ZIP实体，并添加进压缩包
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);

                            //读取待压缩的文件并写进压缩包里
                            fis = new FileInputStream(sourceFiles[i]);
                            bis = new BufferedInputStream(fis, 1024*10);
                            int read = 0;
                            while((read=bis.read(bufs, 0, 1024*10)) != -1){
                                zos.write(bufs,0,read);
                            }
                            if(null != bis){
                                bis.close();
                            }
                        }
                        flag = true;
                        if(null != zos){
                            zos.closeEntry();
                            zos.close();
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally{
                //关闭流
                try {
                    if(null != fis){
                        fis.close();
                    }
                    if(null != fos){
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) throws IOException {
//       String path= System.getProperty("user.dir")+File.separator+"test";
//       path="/Users/administrator/IDEA3/ms-cloud-standard-erp/ms-erp-modules/ms-erp-manager/src/main/resources/templates";
        System.out.println(System.getProperty("user.dir"));
//        boolean aaaa = fileToZip(path, System.getProperty("user.dir"), "aaaa");
//        System.out.println(aaaa);
//        String path=File.separator+"test";
//        boolean b = fileToZip(path, "/aaa", "bbb");
//        System.out.println(b);
    }

}