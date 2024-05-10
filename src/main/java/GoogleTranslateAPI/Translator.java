package GoogleTranslateAPI;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;

public class Translator {

	public static String translateText(String text, String sourceLanguage, String targetLanguage) {
		Translate translate = GoogleTranslateConnection.GoogleTranslateService();

		Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage(sourceLanguage),
				Translate.TranslateOption.targetLanguage(targetLanguage));
		return translation.getTranslatedText();
	}

}
