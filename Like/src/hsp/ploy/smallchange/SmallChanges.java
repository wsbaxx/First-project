package hsp.ploy.smallchange;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//1.完成显示菜单，并可以选择菜单。
//2.完成零钱通明细功能
//3.完成收益入账
//4.完成消费
public class SmallChanges {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        String details = "=============零钱通明细=============";
        double money = 0;
        double balance = 0;
        Date date = null ;//
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        do{
            System.out.println("====零钱通菜单====");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消费");
            System.out.println("\t\t4 退     出");

            System.out.println("请选择 1 - 4");
            key = scanner.next();
            switch (key){
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("收益入账金额:");
                    money = scanner.nextDouble();
                    //money的值应该校验。
                    balance += money;
                    date = new Date();
                    details += "\n收益入账\t+"+ money + "\t" + sdf.format(date) + "\t"+ balance;
                    break;
                case "3":
                    System.out.println("3 消费");
                    break;
                case "4":
                    System.out.println("4 退出");
                    loop = false ;
                    break;
                default:
                    System.out.println("选择有误，重新选择");
            }
        }while(loop);
        System.out.println("你退出了零钱通啦");
    }
}
