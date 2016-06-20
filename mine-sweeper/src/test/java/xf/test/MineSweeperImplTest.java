package xf.test;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author niemar
 *
 */
public class MineSweeperImplTest {

	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionWhenMineFieldIsNull() {
		MineSweeper mineSweeper = new MineSweeperImpl();

		mineSweeper.setMineField(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionWhenMineFieldIsEmpty() {
		MineSweeper mineSweeper = new MineSweeperImpl();

		mineSweeper.setMineField("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionWhenMineFieldContainsNotAllowedChars() {
		MineSweeper mineSweeper = new MineSweeperImpl();

		mineSweeper.setMineField("asd");
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionWhenLinesDontHaveTheSameLength() {
		MineSweeper mineSweeper = new MineSweeperImpl();

		mineSweeper.setMineField("..\n..*.\n....");
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionWhenLinesDontHaveTheSameLength1() {
		MineSweeper mineSweeper = new MineSweeperImpl();

		mineSweeper.setMineField("..**\n*.\n....");
	}

	@Test
	public void ok() {
		MineSweeper mineSweeper = new MineSweeperImpl();
		String mineField = "*...";
		String expectedHintField = "*100";

		mineSweeper.setMineField(mineField);
		String actual = mineSweeper.getHintField();

		assertEquals(expectedHintField, actual);
	}
	
	@Test
	public void ok1() {
		MineSweeper mineSweeper = new MineSweeperImpl();
		String mineField = "....";
		String expectedHintField = "0000";

		mineSweeper.setMineField(mineField);
		String actual = mineSweeper.getHintField();

		assertEquals(expectedHintField, actual);
	}

	@Test
	public void ok2() {
		MineSweeper mineSweeper = new MineSweeperImpl();
		String mineField = "*...*\n*...*";
		String expectedHintField = "*202*\n*202*";

		mineSweeper.setMineField(mineField);
		String actual = mineSweeper.getHintField();

		assertEquals(expectedHintField, actual);
	}

	@Test
	public void ok3() {
		MineSweeper mineSweeper = new MineSweeperImpl();
		String mineField = "*...\n..*.\n....";
		String expectedHintField = "*211\n12*1\n0111";

		mineSweeper.setMineField(mineField);
		String actual = mineSweeper.getHintField();

		assertEquals(expectedHintField, actual);
	}
	
	@Test
	public void ok4() {
		MineSweeper mineSweeper = new MineSweeperImpl();
		String mineField = "*****\n*.*.*\n*****";
		String expectedHintField = "*****\n*8*8*\n*****";

		mineSweeper.setMineField(mineField);
		String actual = mineSweeper.getHintField();

		assertEquals(expectedHintField, actual);
	}

}
