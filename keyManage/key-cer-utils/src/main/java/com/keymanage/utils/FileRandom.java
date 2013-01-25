package com.keymanage.utils;




import java.io.FileWriter;
import java.util.Random;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-1-25 Time: 上午9:14 To change this template use File |
 * Settings | File Templates.
 * key文件自成工具类
 */
public class FileRandom {

    public static final String BASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz~+_-=";
    public static final int MAXNUM = 248;

    /**
     * <p>生成随机的key文件，默认d:/key</p>
     * author:tc
     * @throws Exception
     */
    public static void createFile() throws Exception {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < MAXNUM; i++) {
            sb.append(BASE.charAt(random.nextInt(BASE.length())));
        }
        String str=sb.toString();
        FileWriter writer=new FileWriter("d:/key");
        writer.write(str);
        writer.flush();
        writer.close();
        System.out.println(str);
    }
}
