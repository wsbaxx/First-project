package labor;
import java.util.Scanner;
public class huiwenshu {

    public static void main(String[] args) {
        Panduan panduan = new Panduan();
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        for(int i =0;i<N;i++){
        if(panduan.isSushu2(i)){
            if(panduan.isSushu(i)){
                System.out.println(i+"是素数回文数其各位数字之和是"+panduan.Print(i));
            }
        }
        }
    }
}

class Panduan {

    public boolean isPain(int x) {//把数字首末尾取出来后进行判断，然后将该数/1000
        if (x < 0) return false;
        int high = 1;
        while (x / high > 9) {
            high *= 10;
        }
        while (x > 0) {
            int h = x / high;
            int l = x % 10;
            if (h != l) return false;
            x %= high;
            x /= 10;
            high /= 100;
        }
        return true;
    }

    public boolean isSushu(int x) {
        int i = 2;
        for (i = 2; i <= x / 2; i++) {
            if (x % i == 0) {
                return false;
            }
        }return true;

    }
    public int Print(int x){
        int sum=0;
        while(x>0){
            sum +=x%10;
            x/=10;
        }
        return sum;
    }
    public boolean isSushu2(int x){//判断回文数的方法 把数字转换成字符串
       String str1 = x+"";
       StringBuilder str2 = new StringBuilder(str1);
       str2.reverse();
       int count = 0;
       for(int i=0;i<str1.length();i++){
           if(str1.charAt(i)==str2.charAt(i)){
               count++;
           }
       }
         if(str1.length()==count) return true;
        else return false;
    }

}
