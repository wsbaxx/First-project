package com.events;

public class HomeworkRa {
    public static void main(String[] args) {
         rational1 rational2 = new  rational1();//测试无参构造器
         rational1 rational = new  rational1(2,6);//测试有参构造器
         rational1 rational1 = new  rational1(1, 1);
         rational1 rational3 = new  rational1(5, 3);
        rational2.setNumerator(4);//测试setNumerator方法
        rational2.setDemonitor(6);//测试Setdemonitor方法
        System.out.println(rational2);//验证是否为最简
        rational.Exchange(rational1,rational);//测试Exchange方法
        System.out.println(rational3.Compareto(rational3));//验证交换
        System.out.println(rational);
         rational1 rational4 = new  rational1(4, 6);
        System.out.println(rational4);//测试toString方法
         rational1 rational5 = new  rational1(1,3);
         rational1 rational6 = new  rational1(1,3);
        System.out.println(rational5.getDemonitor());//测试getDemonitor方法
        System.out.println(rational5.getNumerator());//测试getNumrator方法
        System.out.println("加法:"+rational5.add(rational6));//测试加法
        System.out.println("减法:"+rational5.sub(rational6));//测试减法
        System.out.println("乘法:"+rational5.muti(rational6));//测试乘法
        System.out.println("除法:"+rational5.div(rational6));//测试除法
    }
}
class  rational1{
    private int numerator = 1;
    private int demonitor = 1;


    public  rational1(int numerator, int demonitor) {
        this.numerator = numerator;
        this.demonitor = demonitor;
    }

    public  rational1() {
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int a) {
        int c = f(Math.abs(a),demonitor);
        numerator = a/c;
        if(numerator <0&&demonitor<0){
            numerator = -numerator;
            demonitor = -demonitor;
        }
    }

    public int getDemonitor() {
        return demonitor;
    }

    public void setDemonitor(int b) {
        int c = f(numerator,Math.abs(b));
        numerator = numerator/c;
        demonitor = b/c;
        if(numerator<0&&demonitor<0){
            numerator = -numerator;
            demonitor = -demonitor;
        }
    }

    public int f(int a,int b){
        if(a==0)return 1;
        if(a<b){
            int c = a;
            a =b;
            b= c;
        }
        int r = a%b;
        while(r!=0){
            a = b;
            b = r;
            r = a%b;
        }
        return b;
    }

    public  rational1 add( rational1 r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator*b+demonitor*a;
        int newDemonitor = demonitor*b;
         rational1 result = new  rational1();
        result.setNumerator(newNumerator);
        result.setDemonitor(newDemonitor);
        return result;
    }

    public  rational1 sub( rational1 r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator* b- demonitor*a;
        int newDemonitor = demonitor*b;
        rational1 result = new  rational1();
        result.setNumerator(newNumerator);
        result.setDemonitor(newDemonitor);
        return result;
    }

    public  rational1 muti( rational1 r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator*a;
        int newDemonitor = demonitor*b;
         rational1 result = new  rational1();
        result.setDemonitor(newDemonitor);
        result.setNumerator(newNumerator);
        return result;
    }

    public  rational1 div( rational1 r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator*b;
        int newDemonitor = demonitor*a;
         rational1 result = new  rational1();
        result.setDemonitor(newDemonitor);
        result.setNumerator(newNumerator);
        return result;
    }

    public int Compareto( rational1 r){
        int bo = 0;
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator*a - demonitor*b;
        int newDemonitor = demonitor*b;
        if(newNumerator>0) {
            bo = 1;
        }
        if(newNumerator<0){
            bo = -1;
        }
        return bo;
    }

    public void Exchange( rational1 r1, rational1 r2){
        int temp = 0;
        int temp1 = 0;
        temp = r1.numerator;
        r1.numerator = r2.numerator;
        r2.numerator = temp;
        temp1 = r1.demonitor;
        r1.demonitor = r2.demonitor;
        r2.demonitor = temp1;
    }

    @Override
    public String toString() {
        int c = f(this.numerator,this.demonitor);
        int num = 0;
        int dem = 0;
        num = this.numerator/c;
        dem = this.demonitor/c;
        return  num+""+"/"+dem ;
    }
}
