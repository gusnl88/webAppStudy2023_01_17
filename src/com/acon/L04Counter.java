package com.acon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Swing gui Component
//Component > Container(레이아웃 매니저: 다른 컴포넌트 배치)->window(Frame : 종료버튼과 메뉴가 있는 창), panel(Freme 에 포함되어야만 함)
//Component 안에 JComponent 그안에 JList,JLabel,JTable ...등등(컨테이너에 포함될 수 있는 컴포넌트)
//gui 를 구성하는 컴포넌트는 상시 이벤트 발생을 대기한다.
class Counter extends JFrame { //window 필드인 JFrame 이 모든 컴포넌트를 포함할 수 있는 창이기 떄문에
    private final JButton upBtn;//1늘리는 버튼
    private final JButton downBtn; //1줄이는 버튼
    private final JButton initBtn; //초기화
    private final JLabel screen;//카운터화면
    private int count = 0;

    public Counter(String title) {
        super(title); //생성자는 부모의 자식을 구분한다.
        upBtn = new JButton("up");
        downBtn = new JButton("down");
        initBtn = new JButton("Init");
        screen = new JLabel(count + " 명");
        screen.setHorizontalAlignment(JLabel.CENTER);

//        upBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //내부클레스에서 부모 클래스의 필드 접근 법: 부모 클래스명.this.
//                Counter.this.screen.setText(++Counter.this.count + " 명");
//            }
//        });
//        downBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Counter.this.screen.setText(--Counter.this.count + " 명");
//            }
//        });
//
//        initBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Counter.this.count = 0;
//                Counter.this.screen.setText(Counter.this.count+" 명");
//            }
//        });
        this.add(screen, BorderLayout.CENTER);
        this.add(upBtn, BorderLayout.NORTH);
        this.add(downBtn, BorderLayout.SOUTH);
        this.add(initBtn, BorderLayout.EAST);
        //addWindowListener:window 의 테두리의 버튼을 누르는것을 재정의
        WindowHandler A = new WindowHandler();
        this.addWindowListener(A);

        upBtn.addActionListener(new UpBtnHandler());
        downBtn.addActionListener(new DownBtnHandler());
        initBtn.addActionListener(new InitBtnHandler());

        this.setBounds(0, 0, 200, 200);
        this.setVisible(true);

    }
    class UpBtnHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(++count +"명");

        }
    }
    class InitBtnHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText((count=0) +"명");

        }
    }
    class DownBtnHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(count>0) screen.setText(--count +"명");
        }
    }
}


class WindowHandler implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) { //윈도우가 열릴때

    }

    @Override
    public void windowClosing(WindowEvent e) {//닫힘버튼을 누를때
        System.out.println("윈도우가 종료됩니다.");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {//윈도우가 종료될떄

    }

    @Override
    public void windowIconified(WindowEvent e) {//윈도우가 아이콘으로 바뀔떄

    }

    @Override
    public void windowDeiconified(WindowEvent e) {//아이콘에서 창으로 바뀔때

    }

    @Override
    public void windowActivated(WindowEvent e) {//창을 마우스로 누르고 있을 때

    }

    @Override
    public void windowDeactivated(WindowEvent e) {//누르고 있던 마우스를 놓을때

    }
}

public class L04Counter {
    public static void main(String[] args) {
        new Counter("카운터");
    }
}
