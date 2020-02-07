import java.util.ArrayList;
import java.util.List;

public class CalculateADF {

	public static int ADF = 0;

	public static void main(String[] args) {
		String firstStr = "Connecticut is The Constitution State.";
		String secondStr = "Hartford is the capital of Connecticut.";

		firstStr = convertToStandardString(firstStr);
		secondStr = convertToStandardString(secondStr);

		addToADF(firstStr, secondStr);

		System.out.print(ADF);
	}

	public static void addToADF(String firstStr, String secondStr) {
		String commonSubstring = LCS(firstStr, secondStr);

		if (commonSubstring.equals(""))
			return;
		else {
			ADF += commonSubstring.length();

			String str1 = firstStr.substring(0, firstStr.indexOf(commonSubstring));
			String str2 = secondStr.substring(0, secondStr.indexOf(commonSubstring));

			str1 = convertToStandardString(str1);
			str2 = convertToStandardString(str2);

			addToADF(str1, str2);

			String str3 = firstStr.substring(firstStr.indexOf(commonSubstring) + commonSubstring.length());
			String str4 = secondStr.substring(secondStr.indexOf(commonSubstring) + commonSubstring.length());

			str3 = convertToStandardString(str3);
			str4 = convertToStandardString(str4);

			addToADF(str3, str4);
		}

	}

	public static String convertToStandardString(String str) {
		str = str.toUpperCase();
		str = str.replaceAll("[^a-zA-Z]", "");
		return str;
	}

	public static String LCS(String s1, String s2) {
		List<String> substrings = new ArrayList<String>();
		String shortStr, longStr;

		if (s1.length() > s2.length()) {
			shortStr = s2;
			longStr = s1;
		} else {
			shortStr = s1;
			longStr = s2;
		}

		for (int i = 0; i <= shortStr.length(); i++) {
			for (int j = i; j <= shortStr.length(); j++) {
				substrings.add(shortStr.substring(i, j));
			}
		}

		String longestCommonString = "";

		for (String substr : substrings) {
			if (substr.length() > longestCommonString.length()
					|| (substr.length() == longestCommonString.length() && substr.compareTo(longestCommonString) < 0)) {

				if (longStr.indexOf(substr) != -1)
					longestCommonString = substr;
			}
		}

		return longestCommonString;
	}
}
