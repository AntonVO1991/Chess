package Chess;

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn];
                board[startLine][startColumn] = null;
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }











    public boolean castling0() {

        if (nowPlayer.equals("White")) {
            ChessPiece king = board[0][4];
            ChessPiece rook = board[0][0];

            if (king != null && rook != null && king.getCheck() && rook.getCheck() &&
                    board[0][1] == null && board[0][2] == null && board[0][3] == null) {

                board[0][2] = king;
                board[0][4] = null;
                board[0][3] = rook;
                board[0][0] = null;
                king.setCheck(false);
                rook.setCheck(false);
                return true;
            }
        } else if (nowPlayer.equals("Black")) {
            ChessPiece king = board[7][4];
            ChessPiece rook = board[7][0];

            if (king != null && rook != null && king.getCheck() && rook.getCheck() &&
                    board[7][1] == null && board[7][2] == null && board[7][3] == null) {

                board[7][2] = king;
                board[7][4] = null;
                board[7][3] = rook;
                board[7][0] = null;
                king.setCheck(false);
                rook.setCheck(false);
                return true;
            }
        }
        return false;
    }


    public boolean castling7() {

        if (nowPlayer.equals("White")) {
            ChessPiece king = board[0][4];
            ChessPiece rook = board[0][7];

            if (king != null && rook != null && king.getCheck() && rook.getCheck() &&
                    board[0][5] == null && board[0][6] == null) {

                board[0][6] = king;
                board[0][4] = null;
                board[0][5] = rook;
                board[0][7] = null;
                king.setCheck(false);
                rook.setCheck(false);
                return true;
            }
        } else if (nowPlayer.equals("Black")) {
            ChessPiece king = board[7][4];
            ChessPiece rook = board[7][7];

            if (king != null && rook != null && king.getCheck() && rook.getCheck() &&
                    board[7][5] == null && board[7][6] == null) {

                board[7][6] = king;
                board[7][4] = null;
                board[7][5] = rook;
                board[7][7] = null;
                king.setCheck(false);
                rook.setCheck(false);
                return true;
            }
        }
        return false;
    }
}