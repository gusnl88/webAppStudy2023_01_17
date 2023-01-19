package com.acon;

import java.util.Scanner;

public class L07Thread {
    public static void main(String[] args) throws InterruptedException {
        //스레드 : 일의 단위
        //java.lang.Thread : 스레드를 생성할 수 있는 객체.
        //main() : 실행하는 일의 집합으로 기본 1스레드를 갖는다.
        //순차적언어 : main 에 작성한 코드가 한개의 스레드에 의해서 순서대로 실행된다.

        boolean start=true;
        int index = 10;//1초에 한번씩 0까지 1씩 줄이면서 콘솔에 출력하는 어플
        Scanner sc = new Scanner(System.in);
        System.out.println("0을 누르면 카운터카 종료 됩니다.");
        String num = sc.nextLine();//콘솔창에서 입력하는 문자열과 jvm이 통신해서 받아오는 결과는 무조건 문자열이다.

        if(num.equals("0")) start=false;
        while(index>=0 && start){
            System.out.println(index--);
            Thread.sleep(1000);


        }
        System.out.println("타이머 종료");
    }

}
