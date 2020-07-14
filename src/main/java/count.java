import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class count {
    //   读取txt文件的内容
    //   @param file 想要读取的文件对象
    //   @return 返回文件内容    //在操作台显示
    public static String txt2String(File file){
        String result = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));   //构造一个BufferedReader类来读取文件
            String s = null;
            FileWriter fw = null;
            try {                                                 //拿到while外面，运行更快
                File f=new File("G:\\Last1000.txt");   //如果文件存在，则追加内容；如果文件不存在，则创建文件
                fw = new FileWriter(f, true);         //true:追加写入
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pw = new PrintWriter(fw,true);

            while((s = br.readLine()) != null){                               //使用readLine方法，一次读一行
                JSONObject object = JSON.parseObject(s);          //字符串转换为json对象
                int i = object.getIntValue("起始时间");        //读取json对象中，名字为起始时间的值
                int f = object.getIntValue("flinkTime");
                if ((f-i)>1000) {
                    pw.println(object);
                }
             //   result = result + "\n" +s;       //按行输出到操作台
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        File file = new File("G:/test.txt");
        System.out.println(txt2String(file));

    }
}