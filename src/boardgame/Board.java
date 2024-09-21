package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		//Check the board size
		if(rows<1 || columns <1) {
			throw new BoardException("Error in board creation. ");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	public Piece piece(int rows, int columns) {
		if (!positionExists(rows,columns)) {
			throw new BoardException("Position not on the board. ");
		}
		return pieces[rows][columns];
	}
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board. ");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is a piece in postion " + position.getRow() + ", " +position.getColumn() + ". ");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >=0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return position.getRow() >= 0 && position.getRow() < rows && position.getColumn() >=0 && position.getColumn() < columns;
	}
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board. ");
		}
	
		return piece(position) != null; 
	}
	public Piece reomvePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board. ");
		}
		if(piece(position)==null){
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()]=null;
		return aux;
	}
}
