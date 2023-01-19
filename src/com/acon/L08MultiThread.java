package com.acon;


import java.util.Scanner;

class ConsoleTimer implements Runnable{//멀티 스레드로 생성되려면 Runnable
    int index =10;
    boolean start = true;
    @Override
    public void run() {

        while(index>0 && start){
            System.out.println(index--);
            try {Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("타이머 종료 !");
    }

}
public class L08MultiThread {
    public static void main(String[] args) {

        ConsoleTimer ct=new ConsoleTimer();
        new Thread(ct).start();//구현한 run 메소드를 스레드 생성 후 실행

        Scanner sc = new Scanner(System.in);
        System.out.println("0을 누르면 카운터카 종료 됩니다.");
        String num= sc.nextLine();
        System.out.println("입력한 번호: "+num);

        if(num.equals("0")) ct.start=false;



    }
}
