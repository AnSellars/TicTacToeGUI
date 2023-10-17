import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TicTacToeFrame extends JFrame
{

    JPanel mainPnl;
    JPanel boardPnl;
    JPanel quitPnl;

    JButton quitBtn;

    public TicTacToeFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        setTitle("Tic Tac Toe");

        createBoardPnl();
        mainPnl.add(boardPnl,BorderLayout.NORTH);
        createQuitPnl();
        mainPnl.add(quitPnl,BorderLayout.SOUTH);
        add(mainPnl);

        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        TicTacToe.clearBoard();
        new TicTacToe().main();

    }

    public static class TicTacToeBtn extends JButton
    {

        private int row;
        private int col;
        private boolean used = false;
        private String player;

        public TicTacToeBtn(int row, int col, boolean used)
        {
            super();
            this.row = row;
            this.col = col;
            this.used = used;
            this.setFont(new Font("Arial", Font.BOLD, 128));
            this.setText(" ");

            addActionListener((ActionEvent ae) ->
                {
                    if (this.used == false)
                    {
                        player = new TicTacToe().getPlayer();
                        if (player == "X")
                        {
                            TicTacToe.board[this.row - 1][this.col - 1] = "X";
                            this.setText("X");
                        }
                        else
                        {
                            TicTacToe.board[this.row - 1][this.col - 1] = "O";
                            this.setText("O");
                        }
                        this.used = true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid move, please try again");
                    }
//                    System.out.println(row + " " + col + " " + used + " " + valid + " " + player);


                this.player = TicTacToe.getPlayer();
                }

            );
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

    }

    public static class boardClear
    {

        private int row;
        private int col;
        private boolean used;

        public boardClear (int row, int col, boolean used)
        {
            this.row = row;
            this.col = col;
            this.used = used;
            used = false;
            new TicTacToe().setPlayer(" ");

        }



    }

    private void createBoardPnl()
    {

        boardPnl = new JPanel();
        boardPnl.setLayout(new GridLayout(3,3));
        boardPnl.add(new TicTacToeBtn(1,1,false));
        boardPnl.add(new TicTacToeBtn(1,2,false));
        boardPnl.add(new TicTacToeBtn(1,3,false));
        boardPnl.add(new TicTacToeBtn(2,1,false));
        boardPnl.add(new TicTacToeBtn(2,2,false));
        boardPnl.add(new TicTacToeBtn(2,3,false));
        boardPnl.add(new TicTacToeBtn(3,1,false));
        boardPnl.add(new TicTacToeBtn(3,2,false));
        boardPnl.add(new TicTacToeBtn(3,3,false));


    }

    private void createQuitPnl()
    {

        quitPnl = new JPanel();
        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Roboto", Font.PLAIN, 24));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitPnl.add(quitBtn);

    }
}
