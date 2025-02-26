package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro ao criar tabuleiro: é necessário ter pelo menos 1 linha e 1 coluna!");
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

	// método para retornar a linha e coluna do quadro de xadrez
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Posição de coluna e linha não existe!");
		}
		return pieces[row][column];
	}

	// método para retornar a posição da peça no quadro
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição não existe!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	// método responsável por colocar a peça na posição
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("já tem uma peça em posição: " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição não existe!");
		}
		return piece(position) != null;
	}

}
