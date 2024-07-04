package id45.id45____;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class App {

    public static int num =0;
    public static int numY = 700;
    public static int numX = 300;

    public static int numXSave = -250;
    public static int numYSave = 720;

    public static boolean stoped=false;
    public static int twoNum=0;
    private static List<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("***Graph***-1.00000v");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 400, 200);
        frame.setLayout(new BorderLayout());

        JButton button1 = new JButton("X");
        button1.setBackground(Color.LIGHT_GRAY);

        JButton button = new JButton("Y");
        button.setBackground(Color.LIGHT_GRAY);

        JButton button2 = new JButton("Reset programm coords");
        button2.setBackground(Color.LIGHT_GRAY);

        JTextField field = new JTextField();
        field.setBackground(Color.DARK_GRAY);
        field.setForeground(Color.ORANGE);

        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {


                updateFile();
            }



            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFile();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFile();
            }

            private void updateFile() {

                String input = field.getText();
                try {
                    int firstNum=num;
                    num = Integer.parseInt(input);
                    numY = Integer.parseInt(input);
                    numX = Integer.parseInt(input);
                    if (firstNum==num) {
                        stoped=true;
                    }

                    twoNum += num-firstNum;


                    if (num >= -999999999 && num <= 999999999) {
                        if (twoNum<firstNum) {
                            numYSave +=5;

                        }else {
                            if (twoNum==firstNum) {


                            }else {
                                if (twoNum>firstNum) {
                                    numYSave -=5;

                                    ;              		   }
                            }

                        }
                    } else {
                        System.err.println("Введенное число выходит за пределы - 999999999");
                    }
                } catch (NumberFormatException e) {

                }




            }
        });



        numXSave += numX;

        numY = 0;


        points.add(new Point(numXSave, numYSave));

        frame.repaint();


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                field.setText("");
                numXSave += numX;

                numY = 0;


                points.add(new Point(numXSave, numYSave));

                frame.repaint();





            }
        });
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    num = 0;
                    numY = 700;
                    numX = 300;
                    numXSave = -250;
                    numYSave = 720;
                    points.remove(num);

                }catch (IndexOutOfBoundsException e1) {
                    System.err.println("Буфер координат пуст");
                }

            }
        });


        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                int width = 10;
                int height = 10;

                g2d.setColor(Color.ORANGE);


                for (Point point : points) {
                    g2d.fillRect(point.x, point.y, width, height);




                    repaint();
                }

                g.setColor(Color.ORANGE);
                g.drawString("program for drawing graphs, click on the x, y button and enter coordinates - example: (pressing the x button)1,2,5,-4,.", 50, 50);
            }
        };
        panel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.setBackground(Color.DARK_GRAY);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(field, BorderLayout.SOUTH);

        frame.add(button1, BorderLayout.WEST);
        frame.add(button2, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
