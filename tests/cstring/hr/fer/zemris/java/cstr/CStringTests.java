package hr.fer.zemris.java.cstr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CStringTests {

	@Test
	public void testCreateCString() {
		CString prvi = new CString(new char[] {'M', 'a', 'r', 'k', 'o'});
		CString drugi = new CString(prvi);
		CString treci = new CString(new char[] {'A', 'n', 'a', 'n', 'a', 's'}, 1, 4);
		CString cetvrti = new CString(treci);
		CString peti = CString.fromString("Sunce");

		assertEquals("Marko", prvi.toString());
		assertEquals("Marko", drugi.toString());
		assertEquals("nana", treci.toString());
		assertEquals("nana", cetvrti.toString());
		assertEquals("Sunce", peti.toString());
	}

	@Test
	public void testCharAt() {
		CString str = new CString(new char[] {'A', 'n', 'a', 'n', 'a', 's'}, 1, 4);

		assertEquals('n', str.charAt(2));
		assertEquals('a', str.charAt(3));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testIllegalCharAt() {
		CString str1 = new CString(new String("Ananas").toCharArray());
		CString str2 = str1.substring(2, 4);

		str2.charAt(3);
	}

	@Test
	public void testIndexOf() {
		CString str = new CString(new char[] {'A', 'n', 'a', 'n', 'a', 's'}, 1, 4);

		assertEquals(0, str.indexOf('n'));
		assertEquals(1, str.indexOf('a'));
		assertEquals(-1, str.indexOf('s'));
	}

	@Test
	public void testStartsWith() {
		char[] ananas = new char[] {'A', 'n', 'a', 'n', 'a', 's'};
		CString str = new CString(ananas);
		CString str2 = new CString(ananas, 0, 3);

		assertTrue(str.startsWith(str2));
		assertTrue(str.startsWith(str2.substring(0, 0)));
		assertTrue(str.startsWith(str.substring(0, 4)));
		assertFalse(str.startsWith(str.substring(1, 4)));
		assertTrue(str2.startsWith(str2.substring(0, 3)));
	}

	@Test
	public void testEndsWith() {
		char[] ananas = new char[] {'A', 'n', 'a', 'n', 'a', 's'};
		CString str = new CString(ananas);
		CString str2 = new CString(ananas, 3, 3);

		assertTrue(str.endsWith(str2));
		assertTrue(str.endsWith(str2.substring(1, 3)));
		assertFalse(str.endsWith(str2.substring(0, 1)));
	}

	@Test
	public void testContains() {
		CString string = new CString(String.valueOf(" Baze podataka  ").toCharArray());
		CString test1 = CString.fromString("podataka");
		CString test2 = CString.fromString(" Baze podataka  ");
		CString test3 = CString.fromString("taka  r");

		assertTrue(string.contains(test1));
		assertTrue(string.contains(test2));
		assertFalse(string.contains(test3));
	}

	@Test
	public void testSubstring() {
		CString str1 = new CString(new String("Ananas").toCharArray());
		CString str2 = str1.substring(1, 5);
		CString str3 = str2.substring(1, 3);
		CString str4 = str3.substring(1, 2);
		CString str5 = str4.substring(0, 0);

		assertEquals("nana", str2.toString());
		assertEquals("an", str3.toString());
		assertEquals("n", str4.toString());
		assertEquals("", str5.toString());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIllegalSubstring() {
		CString str1 = new CString(new String("Ananas").toCharArray());
		CString str2 = str1.substring(2, 5);

		str2.substring(3, 3);
	}

	@Test
	public void testLeft() {
		char[] ananas = new char[] {'A', 'n', 'a', 'n', 'a', 's'};
		CString str = new CString(ananas);
		CString str2 = str.substring(1, 6);

		assertEquals("", str.left(0).toString());
		assertEquals("Ana", str.left(3).toString());
		assertEquals("Ananas", str.left(6).toString());
		assertEquals("na", str2.left(2).toString());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIllegalLeft() {
		CString str1 = new CString(new String("Ananas").toCharArray());
		CString str2 = str1.substring(2, 5);

		str2.left(4);
	}

	@Test
	public void testRight() {
		char[] ananas = new char[] {'A', 'n', 'a', 'n', 'a', 's'};
		CString str = new CString(ananas);
		CString str2 = str.substring(1, 5);

		assertEquals("", str.right(0).toString());
		assertEquals("nas", str.right(3).toString());
		assertEquals("Ananas", str.right(6).toString());
		assertEquals("ana", str2.right(3).toString());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIllegalRight() {
		CString str1 = new CString(new String("Ananas").toCharArray());
		CString str2 = str1.substring(2, 5);

		str2.right(4);
	}

	@Test
	public void testAdd() {
		CString str1 = new CString(new String("Ananas").toCharArray());
		CString str2 = new CString(new String("  +   ").toCharArray());
		CString str3 = new CString(new String("").toCharArray());

		assertEquals("Ananas", str1.left(3).add(str1.right(3)).toString());
		assertEquals("Ananas", str1.add(str3).toString());
		assertEquals("Ananas  +   Ananas", str1.add(str2).add(str1).toString());
		assertEquals("", str3.add(str3).toString());
	}

	@Test
	public void testReplaceAllWithChars() {
		CString str = new CString(new String("ananas").toCharArray());
		CString str2 = new CString(new String(" a aasaa ").toCharArray());

		assertEquals("ababas", str.replaceAll('n', 'b').toString());
		assertEquals("nnnnns", str.replaceAll('a', 'n').toString());
		assertEquals(" s sssss ", str2.replaceAll('a', 's').toString());
	}

	@Test
	public void testReplaceAllWithStrings() {
		CString str = new CString(new String("Banana").toCharArray());
		CString str2 = new CString(new String("ananas").toCharArray());
		CString sub1 = new CString(new String("ana").toCharArray());
		CString sub2 = new CString(new String("a").toCharArray());
		CString sub3 = new CString(new String("").toCharArray());
		CString sub4 = new CString(new String("z").toCharArray());

		assertEquals("Bana", str.replaceAll(sub1, sub2).toString());
		assertEquals("anananananas", str2.replaceAll(sub2, sub1).toString());
		assertEquals("aaanaaanaaasa", str2.replaceAll(sub3, sub2).toString());
		assertEquals("nas", str2.replaceAll(sub1, sub3).toString());
		assertEquals("ananas", str2.replaceAll(sub4, sub1).toString());
		assertEquals("abababababab", CString.fromString("ababab")
				.replaceAll(CString.fromString("ab"), CString.fromString("abab")).toString());

	}

}
