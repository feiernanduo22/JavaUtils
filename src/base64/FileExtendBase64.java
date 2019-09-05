package base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class FileExtendBase64 {
    /**
     * 将文件转为base64
     */
    public static String fileToBase64(String path) throws Exception{
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * 将base64转换为文件
     */
    public static void base64ToFile(String base64Code, String targetPath) throws Exception{
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    /**
     * 将base64保存到文本文件
     */
    public static void base64InFile(String base64Code, String targetPath) throws Exception{
        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    /**
     * 从文本文件读取base64
     */
    public static String readBase64(String path) throws Exception{
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String temp = null;
        while ((temp = br.readLine()) != null){
            sb.append(temp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            String base64 = fileToBase64("E://03 study/test/test.txt.gz");
            System.out.println("文件转换为base64成功");
            base64InFile(base64, "E://03 study/test/222.txt");
            System.out.println("保存成功");


            /*String txt = readBase64("E://03 study/test/111.txt");
            base64ToFile(txt, "E://03 study/test/222.png");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
