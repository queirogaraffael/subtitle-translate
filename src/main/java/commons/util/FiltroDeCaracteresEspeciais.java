package commons.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FiltroDeCaracteresEspeciais {
	public static String filter(String phrase) {
		String charactersNotIncluded = "[\"!@ $%¨&*()_+=´`{}\\[\\]^~,.<>:;1234567890\\\\/?-]";

		Pattern pattern = Pattern.compile(charactersNotIncluded);

		Matcher matcher = pattern.matcher(phrase);
		String filteredName = matcher.replaceAll("");

		return filteredName;

	}
}
