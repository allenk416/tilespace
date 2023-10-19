// package com.sxt;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game1 extends JFrame implements KeyListener{
     // 4 rows, 6 columns
     private static final int game_row = 4;
     private static final int game_col = 6;

     // 
     JTextArea[][] text,text_dot;
     // 
     Color[][] data;
     Color[] colors;
     // 
     boolean ismatch;
     // 
     // 
     Random r = new Random();

     public void initWindow(){
        this.setSize(800, 600);

        this.setVisible(true);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        this.setTitle("g1");

     }

     public void initGamePanel(){
          // JLayeredPane layeredPane = new JLayeredPane();
          
          // JPanel game_main = new JPanel();
          // game_main.setBounds(0, 0, 800-game_row*3, 600-game_col*3-20);
          // game_main.setLayout(new GridLayout(game_row, game_col,1,1));
          // // 
          // for(int i = 0; i< text.length;i++){
          //      for(int j = 0 ; j<text[i].length;j++){
          //           text[i][j] = new JTextArea(game_row,game_col);
          //           text[i][j].setBackground(Color.WHITE);
          //           text[i][j].addKeyListener(this);
          //           if (j==0||j == text[i].length - 1||i == text.length-1){
          //                text[i][j].setBackground(Color.MAGENTA);
          //                // data[i][j] = 1;

          //           }
          //           text[i][j].setEditable(false);
          //           game_main.add(text[i][j]);
          //      }
          // // this.setLayout(new BorderLayout());
          
          
          // // this.add(game_main,BorderLayout.CENTER,0);
          // }

          JPanel game_dot = new JPanel();
          // game_dot.setBounds(0, 0, 800-game_row*3, 600-game_col*3-20);
          game_dot.setLayout(new GridLayout(game_row*3, game_col*3,1,1));
          
          
          for (int i=1; i< text_dot.length;i+=3){
               for(int j=1; j< text_dot[i].length;j+=3){
                    data[i][j] = colors[r.nextInt(3)];
                    for (int k = i-1; k<=i+1;k++){
                         for (int t = j-1; t<=j+1;t++){
                              data[k][t] = data[i][j];
                         }
                    }
               }
          }
          // int a = r.nextInt(4);
          move(0, 0, 0, 0);

          
          // 
          for(int i = 0; i< text_dot.length;i++){
               for(int j = 0 ; j<text_dot[i].length;j++){
                    text_dot[i][j] = new JTextArea(game_row*3,game_col*3);
                    text_dot[i][j].setBackground(data[i][j]);
                    text_dot[i][j].addKeyListener(this);
                    // if (j==0||j == text_dot[i].length - 1||i == text_dot.length-1){
                    //      text_dot[i][j].setBackground(Color.MAGENTA);
                    //      data_dot[i][j] = 1;

                    // }
                    text_dot[i][j].setEditable(false);
                    
                    game_dot.add(text_dot[i][j]);
                    
                    
               }
          this.setLayout(new BorderLayout());
          
          
          this.add(game_dot,BorderLayout.CENTER,0);
          }
          // this.setLayout(new BorderLayout());
          // this.add(game_main,BorderLayout.CENTER,0);
          // this.add(game_dot,BorderLayout.CENTER,1);
          // JPanel dot = new JPanel();
          // layeredPane.setLayout(new BorderLayout());
          // layeredPane.add(game_main,BorderLayout.CENTER,2);
          // layeredPane.add(game_dot,BorderLayout.CENTER,1);
          // JPanel jp3 = new JPanel();
	     // jp3.setBounds(90, 90, 100, 100);
	     // jp3.setBackground(Color.green);
          
	     // layeredPane.add(jp3, 0);
          // MyPanel dot = new MyPanel();
	     // dot.setBounds(90, 90, 100, 100);
	     // dot.setBackground(Color.green);
          
	     // layeredPane.add(dot, 0);
          // g1 = new MyPanel();
          // this.add(g1,1);
          // layeredPane.add(g1,0);
          // this.add(game_dot,BorderLayout.CENTER);
          // this.add(dot,1);
          
          
     
         
     }
     public void move(int x,int y,int d1,int d2){
          // 00:up 01:down 10:left 11:right
          int row_group[] = {x+game_row*3,x+2};
          int col_group[] = {y+2,y+game_col*3};
          int row = row_group[d1],col = col_group[d1];
          Color first_color = data[x][y];
          for (int i=x; i < row;i+=3){
               for(int j=y; j< col;j+=3){
                    System.out.print(i);
                    System.out.println(j);
                    int i2 = i%(game_row*3);
                    int j2 = j%(game_col*3);
                    for (int k = i2; k<=i2+2;k++){
                         for (int t = j2; t<=j2+2;t++){
                              if (k%3==1&&t%3==1){
                                   continue;
                              }
                              if (i==x+game_row*3||j==y+game_col*3){
                                   data[k][t] = first_color;
                                   continue;
                              }
                              data[k][t] = data[(k+3)%(game_row*3)][(t+3)%(game_col*3)];
                         }
                    }
               }
          }
     }



   public Game1(){
     // text = new JTextArea[game_row][game_col];
     // data = new int[game_row][game_col];
     data = new Color[game_row*3][game_col*3];
     text_dot = new JTextArea[game_row*3][game_col*3];
     colors = new Color[] {Color.RED,Color.YELLOW,Color.BLUE};
     // data_dot = new int[game_row*3][game_col*3];
     initGamePanel();
    initWindow();
    ismatch = false;
     try {
          Thread.sleep(5);      
     }catch (InterruptedException e){
          e.printStackTrace();
     }
    
   }
   public static void main(String[] args){
        Game1 game1 = new Game1();
   }
   public void game_begin(){
     while(true){
          if (ismatch){
               break;
          }

     }
 
   }
   @Override
   public void keyTyped(KeyEvent e){

   }
   @Override
   public void keyPressed(KeyEvent e){
     
   }
   @Override
   public void keyReleased(KeyEvent e){
     
   }
}
