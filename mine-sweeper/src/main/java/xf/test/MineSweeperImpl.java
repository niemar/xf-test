package xf.test;

/**
 * @author niemar
 *
 */
public class MineSweeperImpl implements MineSweeper {
	private static final char MINE = '*';
	private static final char NO_MINE = '.';
	private static final char NEW_LINE = '\n';

	private String mineField;

	public void setMineField(String mineField) throws IllegalArgumentException {
		if (!isMineFieldProperlyFormatted(mineField))
			throw new IllegalArgumentException("MineField is not properly formatted !");
		this.mineField = mineField;
	}

	private boolean isMineFieldProperlyFormatted(String mineField) {
		return !isEmpty(mineField) && containsOnlyAllowedChars(mineField.toCharArray())
				&& haveLinesTheSameLength(mineField);
	}

	private boolean isEmpty(String mineField2) {
		return mineField2 == null || mineField2.isEmpty();
	}

	private boolean containsOnlyAllowedChars(char[] charArray) {
		for (int i = 0; i < charArray.length; i++) {
			if (!isAllowedChar(charArray[i]))
				return false;
		}
		return true;
	}

	private boolean isAllowedChar(char c) {
		return c == NO_MINE || c == MINE || c == NEW_LINE;
	}

	private boolean haveLinesTheSameLength(String mineField2) {
		String[] lines = mineField2.split("" + NEW_LINE);
		if (lines.length == 1)
			return true;
		int length = lines[0].length();
		for (int i = 1; i < lines.length; i++) {
			if (length != lines[i].length())
				return false;
		}
		return true;
	}

	public String getHintField() throws IllegalStateException {
		if (mineField == null)
			throw new IllegalStateException("Mine field has not been initialised !");
		char[][] squares = getMineFieldAs2DimCharArray();
		char[][] hints = createEmpty2DimCharArray(squares.length, squares[0].length);

		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				if (squares[i][j] == MINE) {
					hints[i][j] = MINE;
					incrementNoMinesNeighbours(squares, hints, i, j);
				}
			}
		}
		return hintsToString(hints);
	}

	private void incrementNoMinesNeighbours(char[][] squares, char[][] hints, int mineRow, int mineCol) {
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				int hintRow = mineRow + x;
				int hintCol = mineCol + y;
				if(isInRange(hintRow, hintCol, hints) && squares[hintRow][hintCol] != MINE) {
					hints[hintRow][hintCol]++;
				}
			}
		}
	}

	private boolean isInRange(int hintRow, int hintCol, char[][] hints) {
		return (hintRow >= 0 && hintRow < hints.length) && (hintCol >= 0 && hintCol < hints[hintRow].length);
	}
	
	private char[][] getMineFieldAs2DimCharArray() {
		String[] lines = mineField.split("" + NEW_LINE);
		char[][] squares = new char[lines.length][];
		for (int i = 0; i < lines.length; i++) {
			squares[i] = lines[i].toCharArray();
		}
		return squares;
	}
	
	private char[][] createEmpty2DimCharArray(int rows, int cols) {
		char[][] array2d = new char[rows][];
		for (int i = 0; i < array2d.length; i++) {
			array2d[i] = new char[cols];
			for (int j = 0; j < array2d[i].length; j++) {
				array2d[i][j] = '0';
			}
		}
		return array2d;
	}
	
	private String hintsToString(char[][] hints) {
		StringBuilder sb = new StringBuilder();
		sb.append(hints[0]);
		if(hints.length == 1)
			return sb.toString();
		for (int i = 1; i < hints.length; i++) {
			sb.append(NEW_LINE).append(hints[i]);
		}
		return sb.toString();
	}

}
