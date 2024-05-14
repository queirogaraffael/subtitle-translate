package GoogleTranslateAPI;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;

public class Translator {

	public static String tradutorPalavra(String text, String idiomaOriginal, String idiomaASerTraduzido) {
		Translate translate = GoogleTranslateConnection.GoogleTranslateService();

		Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage(idiomaOriginal),
				Translate.TranslateOption.targetLanguage(idiomaASerTraduzido));
		return translation.getTranslatedText();
	}

}
