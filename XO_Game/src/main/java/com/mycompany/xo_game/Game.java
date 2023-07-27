
package com.mycompany.xo_game;
import java.util.Scanner;

public class Game {
    private Board myBoard = new Board();
    private Player p1 = new Player();
    private Player p2 = new Player();
    private int count = 0;
    
    public void readPlayerData(){
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter Player 1 Name: ");
        String s = cin.next();
        p1.setName(s);
        System.out.println("Enter Player 1 Operator ('x' or 'o'): ");
        String op = cin.next();
        p1.setOp(op.charAt(0));
        
        System.out.println("Enter Player 2 Name: ");
        s = cin.next();
        p2.setName(s);
        if (p1.getOp() == 'x' || p1.getOp() == 'X')
            p2.setOp('o');
        else
            p2.setOp('x');
    }
    
    public void play(){
        Scanner cin = new Scanner(System.in);
        readPlayerData();
        myBoard.draw();
        
        while(!myBoard.isFull()){
            Player currentPlayer = p1;
            if (count%2 == 1)
                currentPlayer = p2;
            while(true){
                int pos;
                System.out.println("Select An Empty Position from 1 to 9");
                pos = cin.nextInt();
                if (myBoard.replaceChar(pos, currentPlayer)){
                    break;
                }    
            }
            myBoard.draw();
            if (myBoard.isWin(currentPlayer)){
                System.out.println("The Winner is: " + currentPlayer.getName());
                break;
            }
            count++;
        }
        if (myBoard.isFull()){
            System.out.println("Game is Draw ..");
        }
}
}
