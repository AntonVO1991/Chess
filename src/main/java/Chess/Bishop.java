package Chess;

public class Bishop extends ChessPiece {
    public Bishop(String color, String name) {
        super(color, name);
    }
    public Bishop(String color) {
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


        if (Math.abs(startLine - toLine) == Math.abs(startColumn - toColumn)) {

            int lineDirection = (toLine > startLine) ? 1 : -1;
            int columnDirection = (toColumn > startColumn) ? 1 : -1;

            int currentLine = startLine + lineDirection;
            int currentColumn = startColumn + columnDirection;

            while (currentLine != toLine && currentColumn != toColumn) {
                if (board.board[currentLine][currentColumn] != null) {
                    return false;
                }
                currentLine += lineDirection;
                currentColumn += columnDirection;
            }

            return true;
        }

        return false;
    }
    @Override
    public char getSymbol() {
        return 'B';
    }
}
