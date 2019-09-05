package csvUtil;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 读取csv
 */
public class CsvReader {
    private BufferedReader bufferedReader;
    public static int readLineCount = 0;
    private List listReader;

    public CsvReader(){
        this.bufferedReader = null;
        this.listReader = new ArrayList();
    }

    /**
     * 打开文件
     * @param file
     */
    public void openCsvFileReader(File file)
    {
        try {
            this.bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GB2312"));
        }
        catch (Exception e){
            System.out.println(e.getCause());
        }
    }

    /**
     * 打开文件
     * 指定编码格式
     * @param file
     * @param charCode
     */
    public void openCsvFileReader(File file, String charCode)
    {
        try {
            this.bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charCode));
        }
        catch (Exception e){
            System.out.println(e.getCause());
        }
    }

    /**
     * 读取所有内容
     */
    public void readCsvFile()
    {
        try{
            String stemp;
            int rowcount = 0;
            while ((stemp = bufferedReader.readLine()) != null && stemp.split(",").length != 0)
            {
                if (stemp.split(",") != null && stemp.split(",").length != 0)
                {
                    listReader.add(stemp);
                }
                rowcount++;
            }
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
    }

    /**
     * 获得内容列表
     * @return
     */
    public List getList()
    {
        return this.listReader;
    }

    /**
     * 关闭csv
     */
    public void closeCsvFileReader(){
        try {
            this.bufferedReader.close();
            this.listReader.clear();
        }catch (Exception e){
            System.out.println(e.getCause());
        }

    }

    /**
     * 读取一行
     * @return
     */
    public String readCsvOneline()
    {
        try {
            String stemp;
            if ((stemp = bufferedReader.readLine()) != null && stemp.trim().length() != 0)
            {
                if (stemp.split(",") != null && stemp.split(",").length != 0)
                {
                    return stemp;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getCause());
            return null;
        }
        return null;
    }

    /**
     * 获取时间
     * @return
     */
    public static String getTime()
    {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        return time;
    }

    public static void main(String[] args) {
        CsvReader reader = new CsvReader();
        File file = new File("E://111.csv");
        reader.openCsvFileReader(file);
        reader.readCsvFile();
        List list = reader.getList();
        System.out.println(list.toString());
        reader.closeCsvFileReader();
        System.out.println(getTime());
    }
}
