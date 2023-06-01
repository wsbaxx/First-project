package com.Homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class Mypanel  {
    JTextField text;
    JFrame frame;
    JTextField t1;
    JButton b1;

    JButton b2;
    JPanel p1;
    JPanel p2;

   public Mypanel(){
       frame=new JFrame("Calculate Demo");
       frame.setSize(600, 300);
       t1=new JTextField(15);
       text = new JTextField(15);
       text.setEditable(false);
       b1=new JButton("从小到大" );
       b2= new JButton("从大到小");
       p1=new JPanel();
       p2=new JPanel();
       p1.add(new JLabel("请输入分数"));
       p1.add(t1);
       p1.add(b1);
       p1.add(b2);
       p2.add(new JLabel("排序结果"));
       p2.add(text);
       frame.add(p1,BorderLayout.NORTH);
       frame.add(p2,BorderLayout.CENTER);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       b1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String s1 = t1.getText().trim();
               String[] string = s1.split(",");
               HashSet hashSet = new HashSet();
               int[] nums = new int[string.length];
               for (int i = 0; i < string.length; i++) {
                   //将字符串参数作为有符号的十进制整数进行解
                   nums[i] = Integer.parseInt(string[i]);
               }
               for(int j=0;j<hashSet.size();j++){
                   hashSet.add(nums[j]);
               }
               for(int k=0;k<hashSet.size();k++){
                   String jk = String.valueOf(nums[k]);
                   text.setText(jk);
               }
           }
       });
   }
}


class rational {
    private int numerator = 1;
    private int demonitor = 1;

    public rational(int numerator, int demonitor) {
        this.numerator = numerator;
        this.demonitor = demonitor;
    }

    public rational() {
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

    public rational add(rational r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator*b+demonitor*a;
        int newDemonitor = demonitor*b;
        rational result = new rational();
        result.setDemonitor(newDemonitor);
        result.setNumerator(newNumerator);
        return result;
    }

    public rational sub(rational r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator* b- demonitor*a;
        int newDemonitor = demonitor*b;
        rational result = new rational();
        result.setDemonitor(newDemonitor);
        result.setNumerator(newNumerator);
        return result;
    }

    public rational muti(rational r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator*a;
        int newDemonitor = demonitor*b;
        rational result = new rational();
        result.setDemonitor(newDemonitor);
        result.setNumerator(newNumerator);
        return result;
    }

    public rational div(rational r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator*b;
        int newDemonitor = demonitor*a;
        rational result = new rational();
        result.setDemonitor(newDemonitor);
        result.setNumerator(newNumerator);
        return result;
    }

    public int Compareto(rational r){
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

    public void Exchange(rational r1, rational r2){
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