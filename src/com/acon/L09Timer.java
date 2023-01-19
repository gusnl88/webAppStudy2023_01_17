package com.acon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SwingTimer extends JFrame {
    int count = 100;
    boolean start = false;
    JButton startBtn = new JButton("시작");
    JButton stopBtn = new JButton("멈춤");
    JButton initBtn = new JButton("초기화");

    Panel btnP=new Panel();
    JLabel screen= new JLabel(this.count/10.0+"초" );

    public SwingTimer(){
        this.add(screen);
        btnP.setLayout(new GridLayout());
        btnP.add(startBtn);
        btnP.add(stopBtn);
        btnP.add(initBtn);
        this.add(btnP,BorderLayout.SOUTH);
        screen.setHorizontalAlignment(JLabel.CENTER);

        this.setBounds(0,0,300,300);
        this.setVisible(true);

        startBtn.addActionListener(new startBtnHandler());
        stopBtn.addActionListener(e -> {
            start = false;
            screen.setText(count/10.0+"초 시작버튼을 눌러주세요");
        });
        initBtn.addActionListener(e -> {
            start= false;
            count=100;

            screen.setText(count/10.0+"시작버튼을 눌러주세요");
        });

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    class startBtnHandler implements ActionListener{
        //startBtnHandler 가 ActionListener 타입이 될수 있는 것은 객체지향의 어떤 특징때문인가요?
        //상속받은 부모의 타입이 될 수 있는 타입의 다형성
        //addActionListener(ActionListener al) :ActionListener를 구현하도록 강제해서 타입을 명확하게 한다.(오류를 줄인다.)

        //document.getElementById("userId").addEventListener("change",function(){});
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!start){
                start=true;
            }else{
                return;
            }
             Runnable run=()->{
                        while(count>0 && start) {
                            screen.setText((count--)/10.0 + "초");
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            if (count == 0) screen.setText("초기화 버튼을 눌러주세요!");
                        }

            };

            new Thread(run).start();
        }
    }

}
public class L09Timer  {
    public static void main(String[] args) {
        new SwingTimer();
    }
}
