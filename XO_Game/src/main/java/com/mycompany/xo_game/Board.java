
package com.mycompany.xo_game;

public class Board{
    char [][]arr;
    
    public Board(){
        this.arr = new char[][]{{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
    }
    
    public int getRow(int index){
        if (index < 0){
            return -1;
        }
        return ((index-1)/3);
    }
    
    public int getCol(int index){
        return ((index-1)%3);
    }
    
    public boolean isEmpty(int index){
        if (index < 1 || index > 9 )
            return false;
        int row = getRow(index);
        int col = getCol(index);
        if (arr[row][col] == 'o' || arr[row][col] == 'O' || arr[row][col] == 'x' || arr[row][col] == 'X'){
            return false;
        }
        return true;
    } 
    
    public boolean replaceChar(int index, Player p){
        if(isEmpty(index)){
            int row = getRow(index);
            int col = getCol(index);
            arr[row][col]=p.getOp();
            return true;
        }
        return false;
    }
    
    public void draw(){
        for (int i=0; i<3; i++){
            System.out.println("--------------------");
            for (int j=0; j<3; j++){
                System.out.print("| " + arr[i][j]+ " ");
            }
            System.out.println("|");
        }
        System.out.println("--------------------");
    }
    
    public boolean isFull(){
        int count = 0;
        for (int i = 1; i <= 9; i++){
            if (isEmpty(i))
                count++;
        }
        if (count == 0){
            return true;
        }
        return false;
    }
    
    public boolean isWin(Player p){
        if (arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2] && arr[0][1] == arr[0][2])
            return true;
        if (arr[1][0] == arr[1][1] && arr[1][0] == arr[1][2] && arr[1][1] == arr[1][2])
            return true;
        if (arr[2][0] == arr[2][1] && arr[2][0] == arr[2][2] && arr[2][1] == arr[2][2])
            return true;
        if (arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0] && arr[1][0] == arr[2][0])
            return true;
        if (arr[0][1] == arr[1][1] && arr[0][1] == arr[2][1] && arr[1][1] == arr[2][1])
            return true;
        if (arr[0][2] == arr[1][2] && arr[0][2] == arr[2][2] && arr[1][2] == arr[2][2])
            return true;
        if (arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2] && arr[1][1] == arr[2][2])
            return true;
        if (arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0] && arr[1][1] == arr[2][0])
            return true;
        
        return false;
    }
}
