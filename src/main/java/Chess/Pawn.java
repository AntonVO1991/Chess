package Chess;

public class Pawn extends ChessPiece {
    public Pawn(String color, String name) {
        super(color, name);
    }
    public Pawn(String color) {
        super(color);
    }
    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        return false;
    }
    public boolean canMoveToPosition(ChessBoard board, int startLine, int startColumn, int toLine, int toColumn) {

        if (!board.checkPos(toLine) || !board.checkPos(toColumn)) {
            return false;
        }


        if (startLine == toLine && startColumn == toColumn) {
            return false;
        }


        int direction = (color.equals("White")) ? 1 : -1;


        if (startColumn == toColumn) {

            if (startLine == (color.equals("White") ? 1 : 6)) {
                if (toLine == startLine + 2 * direction && board.board[toLine][toColumn] == null) {
                    return true;
                }
            }

            if (toLine == startLine + direction && board.board[toLine][toColumn] == null) {
                return true;
            }
        }


        if (Math.abs(startColumn - toColumn) == 1 && toLine == startLine + direction) {
            if (board.board[toLine][toColumn] != null && !board.board[toLine][toColumn].getColor().equals(color)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public char getSymbol() {
        return 'P';
    }
}
