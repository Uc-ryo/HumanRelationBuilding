package relation.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetContactStatusTest {

	public SetContactStatus test = new SetContactStatus();

	/**
	 * replaceContactStatusIntToStrのためのテストメソッド
	 */
	public void testReplaceContactStatusIntToStr() {
		String resultConect = test.replaceContactStatusIntToStr(0);

		assertEquals("0", resultConect);
	}

	@Test
	public void setContactSatus() {
		String resultConect = test.changeContactStatusIntegerToStr(0);

		assertEquals("ある", resultConect);
	}

	@Test
	public Integer testReplaceContactSatus() {
		Integer resultConect = test.replaceContactSatus("ない");

		assertEquals(1, resultConect);
	}
}
