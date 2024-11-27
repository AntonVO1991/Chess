package Chess;

public class Rook extends ChessPiece {
    public Rook(String color, String name) {
        super(color, name);
    }
    public Rook(String color) {
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

         if (startLine == toLine) {

             int columnDirection = (toColumn > startColumn) ? 1 : -1;
            int currentColumn = startColumn + columnDirection;

            while (currentColumn != toColumn) {
                if (board.board[startLine][currentColumn] != null) {
                    return false;
                }
                currentColumn += columnDirection;
            }
            return true;
        } else if (startColumn == toColumn) {

            int lineDirection = (toLine > startLine) ? 1 : -1;
            int currentLine = startLine + lineDirection;

            while (currentLine != toLine) {
                if (board.board[currentLine][startColumn] != null) {
                    return false;
                }
                currentLine += lineDirection;
            }
            return true;
        }

        return false;
    }
    @Override
    public char getSymbol() {
        return 'R';
    }
}
