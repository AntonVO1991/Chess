package Chess;

public class King extends ChessPiece {

    public King (String color, String name) {
        super(color, name);
        name = getClass().getName().toString();
    }
    public King(String color) {
        super(color);
        name = getClass().getName().toString();
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

                if (Math.abs(toLine - startLine) <= 1 && Math.abs(toColumn - startColumn) <= 1) {
            return true;
        }

        return false;
    }
    @Override
    public char getSymbol() {
        return 'K';
    }
}