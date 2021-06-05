
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
public class Assignment {

    public static void main(String[] args) {
        intro();
        tic_tac_code();
        
    }
    public static void intro() {
        System.out.println("====================================");
        System.out.println(" WELCOME TO TIC TAC TOE!");
        System.out.println("    Designer: Muhammad Ahtir Saeed\n" +
                            "    Class: COMP 295\n" +
                            "    Date: 12/07/20");
        System.out.println("1 --- person vs. person\n" +
                           "====================================");
     System.out.println("The current status is:");  
     char dummy[][]={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
     status(dummy);
       
    }
    public static void tic_tac_code() {
      char list[][]={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
      Scanner myobj=new Scanner(System.in);
      int player_status=0;
      int count=0;
      
      while (true){
        if (count>=3){
          int return_value=win_status(list);
          if (return_value==1){
               break;
          }
          
        }
        if(count==9){
         System.out.println("It is a draw!");
         //System.out.println("The current status is:");  
         //status(list);
         break;
        }  
        if (player_status==0){
                
                System.out.println("Player 1: make your move");
                System.out.print("Enter Row:");
                int row=myobj.nextInt();
                
                if (row>=1 & row<=3){
                    System.out.print("Enter Column:");
                    int col=myobj.nextInt();
                    if (col>=1 & col<=3){
                        if (list[row-1][col-1]==' '){
                        list[row-1][col-1]='X';
                        System.out.println("Good!The current status is:");
                        player_status=1;
                        count++;
                        status(list);     
                        System.out.println("");
                          }
                       else{
                       System.out.println("Block already filled ,try again");
                       }
                    }
                    else{
                        System.out.println("enter column between 1 and 3");                   
                    }
                }    
                else{
                    System.out.println("enter row between 1 and 3");    
                    }     
        } 
        else{
          System.out.println("Player 2: make your move");
                System.out.print("Enter Row:");
                int row=myobj.nextInt();
                
                if (row>=1 & row<=3){
                    System.out.print("Enter Column:");
                    int col=myobj.nextInt();
                    if (col>=1 & col<=3){
                        if (list[row-1][col-1]==' '){
                        list[row-1][col-1]='O';
                        System.out.println("Good!The current status is:");
                        player_status=0;
                        count++;
                        status(list);
                        System.out.println("");
                        
                          }
                        else{
                        System.out.println("Block already filled ,try again");
                        }
                    }
                    else{
                         System.out.println("enter column between 1 and 3");
                        }
                    
                }
                else{
                System.out.println("enter row between 1 and 3");    
                     }
                    }
                    
                }    
         }
          
    public static void status(char[][] passed_list) {
    
    System.out.println("+-----------+");
    System.out.println("| "+passed_list[0][0]+" | "+passed_list[0][1]+" | "+passed_list[0][2]+" |");
    System.out.println("+-----------+");
    System.out.println("| "+passed_list[1][0]+" | "+passed_list[1][1]+" | "+passed_list[1][2]+" |");
    System.out.println("+-----------+");
    System.out.println("| "+passed_list[2][0]+" | "+passed_list[2][1]+" | "+passed_list[2][2]+" |");
    System.out.println("+-----------+");
    }

    public static int win_status(char[][] passed_list){
        //Even wins
       if (passed_list[0][0]=='X' & passed_list[0][1]=='X' & passed_list[0][2]=='X'){
           System.out.println("Congratulation! Player 1 Won");
          // System.out.println("The current status is:");  
           //status(passed_list);
           return 1;
           
       }
       if (passed_list[1][0]=='X' & passed_list[1][1]=='X' & passed_list[1][2]=='X'){
           System.out.println("Congratulation! Player 1 Won");
          // System.out.println("The current status is:");  
           //status(passed_list);  
           return 1;
       }
       if (passed_list[2][0]=='X' & passed_list[2][1]=='X' & passed_list[2][2]=='X'){
           System.out.println("Congratulation! Player 1 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[0][0]=='X' & passed_list[1][1]=='X' & passed_list[2][2]=='X'){
           System.out.println("Congratulation! Player 1 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[0][2]=='X' & passed_list[1][1]=='X' & passed_list[2][0]=='X'){
           System.out.println("Congratulation! Player 1 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[0][0]=='X' & passed_list[1][0]=='X' & passed_list[2][0]=='X'){
           System.out.println("Congratulation! Player 1 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[0][2]=='X' & passed_list[1][2]=='X' & passed_list[2][2]=='X'){
           System.out.println("Congratulation! Player 1 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[0][1]=='X' & passed_list[1][1]=='X' & passed_list[2][1]=='X'){
           System.out.println("Congratulation! Player 1 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       //Odd wins
       if (passed_list[0][0]=='O' & passed_list[0][1]=='O' & passed_list[0][2]=='O'){
           System.out.println("Congratulation! Player 2 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[1][0]=='O' & passed_list[1][1]=='O' & passed_list[1][2]=='O'){
           System.out.println("Congratulation! Player 2 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[2][0]=='O' & passed_list[2][1]=='O' & passed_list[2][2]=='O'){
           System.out.println("Congratulation! Player 2 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[0][0]=='O' & passed_list[1][1]=='O' & passed_list[2][2]=='O'){
           System.out.println("Congratulation! Player 2 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[0][2]=='O' & passed_list[1][1]=='O' & passed_list[2][0]=='O'){
           System.out.println("Congratulation! Player 2 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[0][0]=='O' & passed_list[1][0]=='O' & passed_list[2][0]=='O'){
           System.out.println("Congratulation! Player 2 Won");
          // System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       }
       if (passed_list[0][2]=='O' & passed_list[1][2]=='O' & passed_list[2][2]=='O'){
           System.out.println("Congratulation! Player 2 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
           
       }
       if (passed_list[0][1]=='O' & passed_list[1][1]=='O' & passed_list[2][1]=='O'){
           System.out.println("Congratulation! Player 2 Won");
           //System.out.println("The current status is:");  
           //status(passed_list); 
           return 1;
       } 
       return 0;
    }
    
    
}

