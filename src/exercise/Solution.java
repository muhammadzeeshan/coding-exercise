package exercise;

public class Solution {

	public static void main(String[] args) {

		StringBuilder builder = new StringBuilder();

		for (String s : args) {
			builder.append(s).append(" ");
		}

		// Remove last space;
		builder.deleteCharAt(builder.length() - 1);

		System.out.println(builder.toString());
		System.out.println(new String(reverseSentence(builder.toString().toCharArray())));

	}

	private static char[] reverseSentence(char[] src) {

		// Good afternoon
		char[] dest = new char[src.length];
		int destEndIndex = 0;
		int srcWordStartIndex = src.length - 1;
		int srcWordEndIndex = src.length - 1;

		for (int i = (src.length - 1); i >= 0; i--) {

			srcWordStartIndex = i;

			if (src[i] == ' ') {
				dest[destEndIndex] = ' ';
				destEndIndex++;
				srcWordEndIndex = (srcWordStartIndex - 1);

			} else if (i == 0 || src[i - 1] == ' ') {

				destEndIndex = copyArray(src, dest, srcWordStartIndex, srcWordEndIndex, destEndIndex);
				srcWordEndIndex = srcWordStartIndex;
			}

		}
		return dest;

	}

	private static int copyArray(char[] src, char[] dest, int start, int end, int destEndIndex) {

		boolean punctuationInStart = isPunctiation(src, start);
		boolean punctuationInEnd = isPunctiation(src, end);

		if (punctuationInEnd) {

			for (int i = start; i < end; i++) {

				if (i == start) {
					dest[destEndIndex] = src[end];
					destEndIndex++;
					dest[destEndIndex] = src[i];

				} else {
					dest[destEndIndex] = src[i];
				}

				destEndIndex++;
			}
		} else {
			for (int i = start; i <= end; i++) {

				dest[destEndIndex] = src[i];

				destEndIndex++;
			}
		}

		return destEndIndex;
	}

	private static boolean isPunctiation(char[] src, int index) {
		return (src[index] == '?' || src[index] == ',');
	}
}
