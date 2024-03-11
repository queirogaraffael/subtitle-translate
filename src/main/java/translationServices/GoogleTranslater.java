package translationServices;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class GoogleTranslater implements Translater {

	private String text;
	private static String APIKey = "chave";
	private static String idiomaDestino = "pt";

	Translate translate = TranslateOptions.newBuilder().setApiKey(APIKey).build().getService();

	Translation traducao = translate.translate(text, Translate.TranslateOption.targetLanguage(idiomaDestino));

	public void setText(String text) {
		this.text = text;
	}

	public String getTranslation() {
		return traducao.getTranslatedText();
	}

}
