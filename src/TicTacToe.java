
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wulft
 */
public class TicTacToe 
{

    private static final int ROW = 3;
    private static final int COL = 3;
    public static String[][] board = new String[ROW][COL];

    public static String getPlayer() {
        return player;
    }

    public static void setPlayer(String player) {
        TicTacToe.player = player;
    }

    public static String player = "X";
    public static int moveCnt = 0;
    /**
     *
     */
    public static void main()
    {
       boolean finished = false;
       boolean playing = true;
       clearBoard();

       final int MOVES_FOR_WIN = 5;
       final int MOVES_FOR_TIE = 7;
       do // program loop
       {
           //begin a game
           player = "X";
           playing = true;
           moveCnt = 0;

           do  // game loop
           {
              // get the move


              
              if(moveCnt >= MOVES_FOR_WIN)
              {
                  if(isWin(player))
                  {
                      JOptionPane.showMessageDialog(null, "Player " + player + " wins!");
                      playing = false;
                  }
              }
              if(moveCnt >= MOVES_FOR_TIE)
              {
                  if(isTie())
                  {
                      JOptionPane.showMessageDialog(null, "It's a Tie!");
                      playing = false;
                  }
              }
              if(player.equals("X"))
              {
                  player = "O";

              }
              else
              {
                  player = "X";
              }
              moveCnt++;
           }while(playing);

           int reply = JOptionPane.showConfirmDialog(null, "Do you want to play again? ", "Continue?", JOptionPane.YES_NO_OPTION);
           if (reply == JOptionPane.YES_OPTION) {
               finished = false;
               clearBoard();
           } else {
               finished = true;
           }
       }while(!finished);
       
        
    }
    
    public static void clearBoard()
    {

       // sets all the board elements to a space
       for(int row=0; row < ROW; row++)
       {
           for(int col=0; col < COL; col++)
           {
               boolean used = false;
               board[row][col] = " ";
               new TicTacToeFrame.boardClear(row+1, col+1, used);
           }
       }



    }


    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }
        
        return false;
    }
    private static boolean isColWin(String player)
    {
       // checks for a col win for specified player
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].equals(player) &&
               board[1][col].equals(player) &&     
               board[2][col].equals(player))
            {
                return true;
            }                
        }
        return false; // no col win
    }
    private static boolean isRowWin(String player)
    {
       // checks for a row win for the specified player
        for(int row=0; row < ROW; row++)
        {
            if(board[row][0].equals(player) &&
               board[row][1].equals(player) &&     
               board[row][2].equals(player))
            {
                return true;
            }                
        }
        return false; // no row win        
    }
    private static boolean isDiagnalWin(String player)
    {
       // checks for a diagonal win for the specified player
        
        if(board[0][0].equals(player) &&
           board[1][1].equals(player) &&    
           board[2][2].equals(player) )
        {
            return true;
        } 
        if(board[0][2].equals(player) &&
           board[1][1].equals(player) &&    
           board[2][0].equals(player) )
        {
            return true;
        }
        return false;
    }
    
    // checks for a tie before board is filled.
    // check for the win first to be efficient
    private static boolean isTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;
        // Check all 8 win vectors for an X and O so 
        // no win is possible
        // Check for row ties
        for(int row=0; row < ROW; row++)
        {
            if(board[row][0].equals("X") || 
               board[row][1].equals("X") ||
               board[row][2].equals("X"))
            {
                xFlag = true; // there is an X in this row
            }
            if(board[row][0].equals("O") || 
               board[row][1].equals("O") ||
               board[row][2].equals("O"))
            {
                oFlag = true; // there is an O in this row
            }
            
            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a row win
            }
            
            xFlag = oFlag = false;
            
        }
        // Now scan the columns
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].equals("X") || 
               board[1][col].equals("X") ||
               board[2][col].equals("X"))
            {
                xFlag = true; // there is an X in this col
            }
            if(board[0][col].equals("O") || 
               board[1][col].equals("O") ||
               board[2][col].equals("O"))
            {
                oFlag = true; // there is an O in this col
            }
            
            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a col win
            }
        }    
        // Now check for the diagonals
        xFlag = oFlag = false;
        
        if(board[0][0].equals("X") ||
           board[1][1].equals("X") ||    
           board[2][2].equals("X") )
        {
            xFlag = true;
        } 
        if(board[0][0].equals("O") ||
           board[1][1].equals("O") ||    
           board[2][2].equals("O") )
        {
            oFlag = true;
        } 
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }        
        xFlag = oFlag = false;        
        
        if(board[0][2].equals("X") ||
           board[1][1].equals("X") ||    
           board[2][0].equals("X") )
        {
            xFlag =  true;
        }
        if(board[0][2].equals("O") ||
           board[1][1].equals("O") ||    
           board[2][0].equals("O") )
        {
            oFlag =  true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }        

        // Checked every vector so I know I have a tie
        return true;
    }
}
