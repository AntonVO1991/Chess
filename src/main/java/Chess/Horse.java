package Chess;

public class Horse extends ChessPiece {
    public Horse (String color, String name) {
        super(color, name);
    }
    public Horse(String color) {
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


        int rowDiff = Math.abs(startLine - toLine);
        int colDiff = Math.abs(startColumn - toColumn);


        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

    @Override
    public char getSymbol() {
        return 'H';
    }
}

