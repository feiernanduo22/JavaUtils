package csvUtil;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class CsvWriter {
    public static void writeCsv(String path)
    {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"GB2312"));
            for (int i=0;i<3000000;i++){
                bufferedWriter.write("00" + "," + "01" + "," + "02");
                bufferedWriter.newLine();
                bufferedWriter.write("10" + "," + "11" + "," + "12");
                bufferedWriter.newLine();
                bufferedWriter.write("20" + "," + "21" + "," + "22");
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println(e.getCause());
        }
    }

    public static void main(String[] args) {
        String path = "E://222.csv";
        writeCsv(path);
    }
}
