package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	// método para retornar a linha e coluna do quadro de xadrez
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	// método para retornar a posição da peça no quadro
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// método responsável por colocar a peça na posição
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

}
