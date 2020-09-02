/**
 * @author ：fuhua zhang
 * @date ：Created in 2020/8/25 15:09
 * @description：
 * @modified By：
 * @version:
 */
public class StringTest {
    public static void main(String[] args) {
        String  trimsql="b.ywlxdm limit 100,100 ";
        if (trimsql.lastIndexOf("limit ") != -1){
            String limit = trimsql.substring(trimsql.lastIndexOf("limit")+5).trim();
            System.out.println(limit);
            if (limit.contains(",")){
                String[] strings = limit.split(",");
                String start=strings[0];
                int endMum=Integer.parseInt(start)+10;
                trimsql=trimsql.replace(limit," "+start+","+endMum);

            }
        }
        Object o=null;
        String s = String.valueOf(o);
        System.out.println(s);
        String qqq="张富华aaa";
        if (qqq.matches("[\u4E00-\u9FA5]+")){
            System.out.println("全部是中文");
        }else {
            System.out.println("有其他符号");
        }
        System.out.println("最终sql:  "+trimsql);
    }
}
