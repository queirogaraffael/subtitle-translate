package GoogleTranslateAPI;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;

public class Translator {

	public static String translateText(String text, String targetLanguage) {
		Translate translate = GoogleTranslateConnection.GoogleTranslateService();

		Translation translation = translate.translate(text, Translate.TranslateOption.targetLanguage(targetLanguage));
		return translation.getTranslatedText();
	}

}
