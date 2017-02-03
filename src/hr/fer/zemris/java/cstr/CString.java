package hr.fer.zemris.java.cstr;

/**
 * Class which offers similar functionality as the old official implementation
 * of the String class: it represents unmodifiable strings on which substring
 * methods (and similar) are executed in O(1) complexity by sharing the
 * character array.
 * 
 * @author labramusic
 *
 */
public class CString {

	/**
	 * Content of the string.
	 */
	private char[] data;

	/**
	 * Index of the starting character in the array.
	 */
	private int offset;

	/**
	 * Number of characters in array.
	 */
	private int count;

	/**
	 * Constructor which initializes a new CString with given values.
	 * 
	 * @param data
	 *            string content
	 * @param offset
	 *            starting index
	 * @param count
	 *            number of characters
	 */
	public CString(char[] data, int offset, int count) {
		if (data == null) {
			throw new IllegalArgumentException("Content cannot be null.");
		}
		if (count != 0 && (offset < 0 || offset >= data.length)) {
			throw new IllegalArgumentException("Illegal offset value.");
		}
		if (count < 0 || count > data.length - offset) {
			throw new IllegalArgumentException("Illegal count value.");
		}
		this.data = data;
		this.offset = offset;
		this.count = count;
	}

	/**
	 * Constructor which initializes a new CString from the given character
	 * array.
	 * 
	 * @param data
	 *            string content
	 */
	public CString(char[] data) {
		this(data, 0, data.length);
	}

	/**
	 * Constructor which initializes a new CString by copying from the given
	 * original value.
	 * 
	 * @param original
	 *            original CString instance
	 */
	public CString(CString original) {
		if (original == null) {
			throw new IllegalArgumentException("Argument cannot be null.");
		}
		if (original.count < original.data.length) {
			data = original.toCharArray();
			offset = 0;
			count = data.length;
		} else {
			data = original.data;
			offset = original.offset;
			count = original.count;
		}
	}

	/**
	 * Returns a new CString object which has the same character data as the
	 * given Java's String object.
	 * 
	 * @param s
	 *            a Java string object
	 * @return CString with the same character data
	 */
	public static CString fromString(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Argument cannot be null.");
		}
		return new CString(s.toCharArray());
	}

	/**
	 * Returns the length of the string.
	 * 
	 * @return string length
	 */
	public int length() {
		return count;
	}

	/**
	 * Returns the character in string at given index position. Index must be
	 * between 0 and n-1, where n is the number of characters in the string.
	 * 
	 * @param index
	 *            index value
	 * @return character at given index
	 */
	public char charAt(int index) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException();
		}
		return data[offset + index];
	}

	/**
	 * Allocates a new array of length equals to length of this CString object,
	 * copies string content into it and returns it.
	 * 
	 * @return character array of data
	 */
	public char[] toCharArray() {
		char[] array = new char[count];
		for (int i = offset, j = 0; i < offset + count; ++i) {
			array[j++] = data[i];
		}
		return array;
	}

	@Override
	public String toString() {
		return new String(this.toCharArray());
	}

	/**
	 * Returns the index of first occurrence of character in string or -1 if
	 * string doesn't contain the given character.
	 * 
	 * @param c
	 *            character being searched for
	 * @return index of character in string
	 */
	public int indexOf(char c) {
		for (int i = 0; i < count; ++i) {
			if (data[offset + i] == c) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns true if this string begins with the given string, false
	 * otherwise.
	 * 
	 * @param s
	 *            CString string object
	 * @return true if string begins with given string
	 */
	public boolean startsWith(CString s) {
		if (s == null) {
			throw new IllegalArgumentException("Argument cannot be null.");
		}
		if (s.count > count) {
			return false;
		}
		for (int i = s.offset, j = offset; i < s.offset + s.count; ++i) {
			if (s.data[i] != data[j++]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if this string ends with the given string, false otherwise.
	 * 
	 * @param s
	 *            CString string object
	 * @return true if string ends with given string
	 */
	public boolean endsWith(CString s) {
		if (s == null) {
			throw new IllegalArgumentException("Argument cannot be null.");
		}
		if (s.count > count) {
			return false;
		}
		int j = offset + count - s.count;
		for (int i = s.offset; i < s.offset + s.count; ++i) {
			if (s.data[i] != data[j++]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if this string contains given string at any position, false
	 * otherwise.
	 * 
	 * @param s
	 *            CString string object
	 * @return true if string contains substring
	 */
	public boolean contains(CString s) {
		if (s == null) {
			throw new IllegalArgumentException("Argument cannot be null.");
		}
		// for each character of the original string
		for (int index = offset; index < offset + count; ++index) {
			if (s.count > count - index + offset) {
				return false;
			}
			int i, j;
			// compare substrings
			for (i = index, j = s.offset; j < s.offset + s.count; ++j) {
				if (data[i++] != s.data[j]) {
					break;
				}
			}
			// contains substring
			if (j == s.offset + s.count) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a new CString which represents a part of the original string in
	 * complexity O(1). The position endIndex does not belong to the substring.
	 * The starting index must be 0 or greater and ending index must be
	 * equal to the starting index or greater.
	 * 
	 * @param startIndex
	 *            starting index, cannot be less than 0
	 * @param endIndex
	 *            end index, cannot be less than startIndex
	 * @return substring of this string
	 */
	public CString substring(int startIndex, int endIndex) {
		if (startIndex < 0 || startIndex >= count) {
			throw new IllegalArgumentException("Illegal starting index.");
		}
		if (endIndex < startIndex || endIndex > count) {
			throw new IllegalArgumentException("Illegal end index.");
		}
		return new CString(data, offset + startIndex, endIndex - startIndex);
	}

	/**
	 * Returns a new CString which represents the starting part of the original
	 * string and is of length n. The length n must be at least 0 and cannot be
	 * greater than the original string length.
	 * 
	 * @param n
	 *            length of new string
	 * @return starting part of original string with length n
	 */
	public CString left(int n) {
		if (n < 0 || n > count) {
			throw new IllegalArgumentException("Illegal length.");
		}
		return new CString(data, offset, n);
	}

	/**
	 * Returns a new CString which represents the ending part of the original
	 * string and is of length n. The length n must be at least 0 and cannot be
	 * greater than the original string length.
	 * 
	 * @param n
	 *            length of new string
	 * @return ending part of original string with length n
	 */
	public CString right(int n) {
		if (n < 0 || n > count) {
			throw new IllegalArgumentException("Illegal length.");
		}
		return new CString(data, offset + count - n, n);
	}

	/**
	 * Creates a new CString which is a concatenation of the current and the
	 * given string.
	 * 
	 * @param s
	 *            string to be concatenated with the original
	 * @return concatenation of the two strings
	 */
	public CString add(CString s) {
		if (s == null) {
			throw new IllegalArgumentException("Argument cannot be null.");
		}
		int length = this.length() + s.length();
		char[] concatenated = new char[length];
		int j = 0;
		for (int i = offset; i < offset + count; ++i) {
			concatenated[j++] = data[i];
		}
		for (int i = s.offset; i < s.offset + s.count; ++i) {
			concatenated[j++] = s.data[i];
		}
		return new CString(concatenated);
	}

	/**
	 * Creates a new CString in which each occurrence of old character is
	 * replaced with new character.
	 * 
	 * @param oldChar
	 *            character to be replaced
	 * @param newChar
	 *            character replacement
	 * @return string with replaced characters
	 */
	public CString replaceAll(char oldChar, char newChar) {
		char[] replaced = new char[count];
		for (int i = offset; i < offset + count; ++i) {
			if (data[i] == oldChar) {
				replaced[i] = newChar;
			} else {
				replaced[i] = data[i];
			}
		}
		return new CString(replaced);
	}

	/**
	 * Creates a new CString in which each occurrence of old substring is
	 * replaced with the new substring.
	 * 
	 * @param oldStr
	 *            substring to be replaced
	 * @param newStr
	 *            substring replacement
	 * @return string with replaced substrings
	 */
	public CString replaceAll(CString oldStr, CString newStr) {
		if (oldStr == null || newStr == null) {
			throw new IllegalArgumentException("Arguments cannot be null.");
		}
		int subNum = countSubstrings(this, oldStr);
		char[] replaced = new char[count - subNum*oldStr.length() + subNum*newStr.length()];
		int k = 0;
		// for each character of the original string
		for (int index = offset; index < offset + count; ++index) {
			if (oldStr.count > count - index + offset) {
				replaced[k++] = data[index];
				continue;
			}
			int i, j;
			// compare substrings
			for (i = index, j = oldStr.offset; j < oldStr.offset + oldStr.count; ++j) {
				if (data[i++] != oldStr.data[j]) {
					break;
				}
			}
			// contains substring
			if (j == oldStr.offset + oldStr.count) {
				// append substring
				for (i = newStr.offset; i < newStr.offset + newStr.count; ++i) {
					replaced[k++] = newStr.data[i];
				}
				// skip substring if string not empty
				if (oldStr.count > 0) {
					index += oldStr.count-1;
				} else {
					replaced[k++] = data[index];
				}
			} else {
				// append that character
				replaced[k++] = data[index];
			}
		}

		// append one more time if replacing empty string
		if (oldStr.count == 0) {
			for (int i = newStr.offset; i < newStr.offset + newStr.count; ++i) {
				replaced[k++] = newStr.data[i];
			}
		}

		return new CString(replaced);
	}

	/**
	 * Counts the number of times the substring appears in the original string.
	 * 
	 * @param s
	 *            original string
	 * @param sub
	 *            substring
	 * @return number of substring appearances in original string
	 */
	private static int countSubstrings(CString s, CString sub) {
		int counter = 0;
		// for each character of the original string
		for (int index = s.offset; index < s.offset + s.count; ++index) {
			if (sub.count > s.count - index + s.offset) {
				break;
			}
			int i, j;
			// compare substrings
			for (i = index, j = sub.offset; j < sub.offset + sub.count; ++j) {
				if (s.data[i++] != sub.data[j]) {
					break;
				}
			}
			// contains substring
			if (j == sub.offset + sub.count) {
				++counter;
				// skip substring if string not empty
				if (sub.count > 0) {
					index += sub.count-1;
				}
			}
		}

		// contains empty string at end 
		if (sub.count == 0) {
			++counter;
		}

		return counter;
	}

}
