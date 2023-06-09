package com.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.*;

public class Labor8 {
    public static void main(String[] args) {
        // 创建窗口、按钮和文本框
        JFrame frame = new JFrame("别报错了");
        JButton button = new JButton("从小到大");
        JButton button1 = new JButton("从大到小");
        JButton button2 = new JButton("加法");
        JButton button3 = new JButton("减法");
        JButton button4 = new JButton("乘法");
        JButton button5 = new JButton("除法");
        JTextField inputField = new JTextField(16);
        JTextField outputField = new JTextField(16);
        JLabel errorLabel = new JLabel();
        // 创建面板，并设置布局为GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // 设置输入文本框的约束
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 0, 10); // 设置边距
        panel.add(new JLabel("输入数字:"), constraints);
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(inputField, constraints);

        // 设置输出文本框的约束
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("运算结果:"), constraints);

        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(outputField, constraints);

        // 设置按钮的约束
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER; // 设置按钮居中对齐
        constraints.insets = new Insets(10, 0, 10, 0); // 设置按钮上下边距
        panel.add(button, constraints);
        constraints.gridx = 1;
        constraints.insets = new Insets(10, 5, 10, 10); // 设置按钮上下边距和右边距
        panel.add(button1, constraints);
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.insets = new Insets(10, 5, 10, 10);
        panel.add(button2,constraints);
        constraints.gridx = 1;
        panel.add(button3,constraints);
        constraints.gridy = 7;
        constraints.gridx = 0;
        panel.add(button4,constraints);
        constraints.gridx = 1;
        panel.add(button5,constraints);

        // 设置错误提示的约束
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.CENTER; // 设置错误提示居中对齐
        constraints.insets = new Insets(0, 0, 10, 0); // 设置错误提示下边距
        panel.add(errorLabel, constraints);

        // 从小到大的按钮的响应
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获取输入文本框的值并进行排序和去重
                String inputValue = inputField.getText().trim();
                String[] numbers = inputValue.split(",");
                Rational[] fractions = new Rational[numbers.length];

                boolean validInput = true;
                try {
                    for (int i = 0; i < numbers.length; i++) {
                        String[] fractionParts = numbers[i].split("/");
                        int numerator = Integer.parseInt(fractionParts[0]);
                        int denominator = Integer.parseInt(fractionParts[1]);
                        fractions[i] = new Rational(numerator, denominator);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                    validInput = false;
                }


                if (validInput) {
                    Arrays.sort(fractions);

                    // 去重操作
                    Set<Rational> uniqueFractions = new LinkedHashSet<>(Arrays.asList(fractions));

                    // 将排序后且去重的结果显示在输出文本框中
                    StringBuilder sortedFractions = new StringBuilder();
                    for (Rational fraction : uniqueFractions) {
                        sortedFractions.append(fraction).append(", ");
                    }

                    // 去除末尾的逗号和空格
                    if (sortedFractions.length() > 0) {
                        sortedFractions.setLength(sortedFractions.length() - 2);
                    }

                    outputField.setText(sortedFractions.toString());
                    errorLabel.setText(""); // 清空错误提示
                } else {
                    errorLabel.setText("你的输入有误");
                }
            }
        });
        //从大到小的按钮响应
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取输入文本框的值并进行排序和去重
                String inputValue = inputField.getText().trim();
                String[] numbers = inputValue.split(",");
                Rational[] fractions = new Rational[numbers.length];

                boolean validInput = true;
                try {
                    for (int i = 0; i < numbers.length; i++) {
                        String[] fractionParts = numbers[i].split("/");
                        int numerator = Integer.parseInt(fractionParts[0]);
                        int denominator = Integer.parseInt(fractionParts[1]);
                        fractions[i] = new Rational(numerator, denominator);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                    validInput = false;
                }

                if (validInput) {
                    Arrays.sort(fractions, new Comparator<Rational>() {
                        @Override
                        public int compare(Rational o1, Rational o2) {
                            int bo = 0;
                            int a = o1.getNumerator();
                            int b = o1.getDemonitor();
                            int c = o2.getNumerator();
                            int d = o2.getDemonitor();
                            double result = (double) a/b - (double) c/d;
                            if(result>0) {
                                bo = -1;
                            }
                            if(result<0){
                                bo = 1;
                            }
                            return bo;
                        }
                    });

                    // 去重操作
                    Set<Rational> uniqueFractions = new LinkedHashSet<>(Arrays.asList(fractions));

                    // 将排序后且去重的结果显示在输出文本框中
                    StringBuilder sortedFractions = new StringBuilder();
                    for (Rational fraction : uniqueFractions) {
                        sortedFractions.append(fraction).append(", ");
                    }

                    outputField.setText(sortedFractions.toString());
                    errorLabel.setText(""); // 清空错误提示
                } else {
                    errorLabel.setText("你的输入有误");
                }
            }
        });
        //加法按钮的响应
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputValue = inputField.getText().trim();
                String[] numbers = inputValue.split(",");
                Rational[] fractions = new Rational[numbers.length];

                boolean validInput = true;
                try {
                    for (int i = 0; i < numbers.length; i++) {
                        String[] fractionParts = numbers[i].split("/");
                        int numerator = Integer.parseInt(fractionParts[0]);
                        int denominator = Integer.parseInt(fractionParts[1]);
                        fractions[i] = new Rational(numerator, denominator);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                    validInput = false;
                }
              if(validInput){
                  for(int i=0;i<fractions.length-1;i++){
                   fractions[i+1] =  fractions[i].add(fractions[i+1]);
                  }
                  StringBuilder sortedFractions = new StringBuilder();
                  sortedFractions.append(fractions[fractions.length-1]);
                  outputField.setText(sortedFractions.toString());
                  errorLabel.setText(""); // 清空错误提示
              }else {
                  errorLabel.setText("你的输入有误");
              }
            }
        });
        //减法按钮的响应
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String inputValue = inputField.getText().trim();
                String[] numbers = inputValue.split(",");
                Rational[] fractions = new Rational[numbers.length];

                boolean validInput = true;
                try {
                    for (int i = 0; i < numbers.length; i++) {
                        String[] fractionParts = numbers[i].split("/");
                        int numerator = Integer.parseInt(fractionParts[0]);
                        int denominator = Integer.parseInt(fractionParts[1]);
                        fractions[i] = new Rational(numerator, denominator);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                    validInput = false;
                }
                if(validInput){
                    for(int i=0;i<fractions.length-1;i++){
                        fractions[i+1] =  fractions[i].sub(fractions[i+1]);
                    }
                    StringBuilder sortedFractions = new StringBuilder();
                    sortedFractions.append(fractions[fractions.length-1]);
                    outputField.setText(sortedFractions.toString());
                    errorLabel.setText(""); // 清空错误提示
                }else {
                    errorLabel.setText("你的输入有误");
                }
            }
        });
        //乘法按钮的响应
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputValue = inputField.getText().trim();
                String[] numbers = inputValue.split(",");
                Rational[] fractions = new Rational[numbers.length];

                boolean validInput = true;
                try {
                    for (int i = 0; i < numbers.length; i++) {
                        String[] fractionParts = numbers[i].split("/");
                        int numerator = Integer.parseInt(fractionParts[0]);
                        int denominator = Integer.parseInt(fractionParts[1]);
                        fractions[i] = new Rational(numerator, denominator);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                    validInput = false;
                }
                if(validInput){
                    for(int i=0;i<fractions.length-1;i++){
                        fractions[i+1] =  fractions[i].muti(fractions[i+1]);
                    }
                    StringBuilder sortedFractions = new StringBuilder();
                    sortedFractions.append(fractions[fractions.length-1]);
                    outputField.setText(sortedFractions.toString());
                    errorLabel.setText(""); // 清空错误提示
                }else {
                    errorLabel.setText("你的输入有误");
                }
            }
        });
        //除法按钮的响应
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputValue = inputField.getText().trim();
                String[] numbers = inputValue.split(",");
                Rational[] fractions = new Rational[numbers.length];

                boolean validInput = true;
                try {
                    for (int i = 0; i < numbers.length; i++) {
                        String[] fractionParts = numbers[i].split("/");
                        int numerator = Integer.parseInt(fractionParts[0]);
                        int denominator = Integer.parseInt(fractionParts[1]);
                        fractions[i] = new Rational(numerator, denominator);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                    validInput = false;
                }
                if(validInput){
                    for(int i=0;i<fractions.length-1;i++){
                        fractions[i+1] =  fractions[i].div(fractions[i+1]);
                    }
                    StringBuilder sortedFractions = new StringBuilder();
                    sortedFractions.append(fractions[fractions.length-1]);
                    outputField.setText(sortedFractions.toString());
                    errorLabel.setText(""); // 清空错误提示
                }else {
                    errorLabel.setText("你的输入有误");
                }
            }
        });

        // 将面板添加到窗口中
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}


class Rational implements Comparable<Rational> {
    private int numerator = 1;
    private int demonitor = 1;

    public Rational(int numerator, int demonitor) {
        this.numerator = numerator;
        this.demonitor = demonitor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return numerator == rational.numerator && demonitor == rational.demonitor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, demonitor);
    }

    public Rational() {
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

    public  Rational add(Rational r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator*b+demonitor*a;
        int newDemonitor = demonitor*b;
        Rational result = new Rational();
        result.setNumerator(newNumerator);
        result.setDemonitor(newDemonitor);
        return result;
    }

    public Rational sub(Rational r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator* b- demonitor*a;
        int newDemonitor = demonitor*b;
        Rational result = new Rational();
        result.setNumerator(newNumerator);
        result.setDemonitor(newDemonitor);
        return result;
    }

    public Rational muti(Rational r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator*a;
        int newDemonitor = demonitor*b;
        Rational result = new Rational();
        result.setNumerator(newNumerator);
        result.setDemonitor(newDemonitor);
        return result;
    }

    public Rational div(Rational r){
        int a = r.getNumerator();
        int b = r.getDemonitor();
        int newNumerator = numerator*b;
        int newDemonitor = demonitor*a;
        Rational result = new Rational();
        result.setNumerator(newNumerator);
        result.setDemonitor(newDemonitor);
        return result;
    }


    public void Exchange(Rational r1, Rational r2){
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


    public int compareTo(Rational r) {
        int bo = 0;
        int a = r.getNumerator();
        int b = r.getDemonitor();
        double result = calculateValue()-r.calculateValue();
        if(result>0) {
            bo = 1;
        }
        if(result<0){
            bo = -1;
        }
        return bo;
    }
    public double calculateValue() {
        return (double) numerator / demonitor;
    }
//    public int compareTo(Rational r){
//        int n=this.demonitor*r.demonitor;
//        r.numerator=r.numerator*this.demonitor;
//        this.numerator=r.demonitor*this.numerator;
//        if(n<0){
//            if(this.numerator>r.numerator){
//                return -1;
//            }else if(this.numerator<r.numerator){
//                return 1;
//            }else{
//                return 0;
//            }
//        }else{
//            if(this.numerator>r.numerator){
//                return 1;
//            }else if(this.numerator<r.numerator){
//                return -1;
//            }else{
//                return 0;
//            }
//        }
//    }
}



