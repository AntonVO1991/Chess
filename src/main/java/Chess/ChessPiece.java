package Chess;

public abstract class ChessPiece {
    protected String color;
    String name;

    public ChessPiece(String color, String name) {
        this.color = color;
        this.name = name;
    }
    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }


    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board);

    @Override
    public String toString() {
        return color.charAt(0) + name.substring(0, 1);
    }
    public boolean canMoveToPosition(int line, int column, int toLine, int toColumn) {
               return false;
    }
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        return false;
    }
    public char getSymbol() {
        return ' ';
    }
    public boolean getCheck() {
        return isCheck;
    }
    public void setCheck(boolean check) {
        isCheck = check;}
    protected boolean isCheck;
}




