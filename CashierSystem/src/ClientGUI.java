import discount.AbstractDiscount;
import util.Util;
import util.XMLUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClientGUI extends JFrame{

    double originalPrice = 600.0;

    //文本框
    TextField tf1,tf2,tf3,tf4;
    public void go(){
        this.setTitle("学生信息登记系统");
        this.setBounds(600, 300, 300, 280);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel p = getCheckBoxPanel();
        this.add(p,BorderLayout.CENTER);
        JPanel p2 = new JPanel();
        JButton button = new JButton("确定");
        p2.add(button, BorderLayout.NORTH);
        JButton button2 = new JButton("重置");
        p2.add(button2, BorderLayout.SOUTH);
        this.add(p2, BorderLayout.SOUTH);
        button.addActionListener(new ButtonListener());
        button2.addActionListener(new Button2Listener());
        this.setVisible(true);
    }
    public JPanel getCheckBoxPanel(){
        XMLUtil xmlUtil = new XMLUtil();
        String name = xmlUtil.getDisount();
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(new JLabel("单        价"));
        p.add(new JLabel("        "));
        p.add(new JLabel(String.valueOf(originalPrice)));
        p.add(new JLabel("                                     "));
//        tf1 = new TextField(20);
//        tf1.setText(String.valueOf(originalPrice));
        //p.add(tf1);
        p.add(new JLabel("数        量"));
        tf2 = new TextField(20);
        tf2.setText("1");
        p.add(tf2);
        p.add(new JLabel("折扣方式"));
        p.add(new JLabel("    "));
        p.add(new JLabel(name));
        p.add(new JLabel("                                     "));
//        tf3 = new TextField(20);
//        tf3.setText(name);
//        p.add(tf3);
        p.add(new JLabel("折后价格"));
        tf4 = new TextField(20);
        p.add(tf4);
        return p;
    }

    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            MarketAccounts ma = new MarketAccounts();
            Util util = new Util();
            double currentPrice;
            ma.setPrice(originalPrice);
            AbstractDiscount discount = (AbstractDiscount) XMLUtil.getBean();
            ma.setDiscount(discount);
            String number = tf2.getText();
            if(number.equals("")){
                tf2.setText("1");
                tf4.setText("");
            }
            else if(util.isNumeric(number)){
                int num = Integer.parseInt(number);
                if(num >= 0){
                    currentPrice = ma.calculate(num);
                    tf4.setText(String.valueOf(currentPrice));
                }else{
                    tf2.setText("1");
                    tf4.setText("");
                }
            }
            else{
                tf2.setText("1");
                tf4.setText("");
            }
        }
    }
    class Button2Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            tf2.setText("1");
            tf4.setText("");
        }
    }

    public static void main(String[] args) {
        ClientGUI demo = new ClientGUI();
        demo.go();
    }
} 