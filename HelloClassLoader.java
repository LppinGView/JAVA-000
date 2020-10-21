package com.java.jvm;

import java.io.*;
import java.util.Base64;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.jvm0104
 * @ClassName: HelloClassLoader
 * @Author: 24tidy
 * @Description
 * @Date: 2020/9/17 14:34
 * @Version: 1.0
 */
public class HelloClassLoader extends ClassLoader {
    
    public static void main(String[] args) {
        try {
            new HelloClassLoader().findClass("Hello").newInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        // 加载D盘根目录下指定类名的class
        String clzDir = "/Hello.xlass";

        byte[] bytes = getClassData(clzDir);
        return defineClass(name,bytes,0,bytes.length);
    }

    private byte[] getClassData(String path) {
        try (InputStream ins = new FileInputStream(path);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ) {

            int bufferSize = 1;
            byte[] buffer = new byte[bufferSize];
            byte[] tempBuffer = new byte[bufferSize];
            int bytesNumRead = 0;
            byte b255 = (byte) 255;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                tempBuffer[0] = (byte) (b255 - buffer[0]);
                baos.write(tempBuffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
