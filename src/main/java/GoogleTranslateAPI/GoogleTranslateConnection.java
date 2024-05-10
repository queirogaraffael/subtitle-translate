package GoogleTranslateAPI;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;

public class GoogleTranslateConnection {
	private static String apiKey = "Key";
	private static Translate translate;

	@SuppressWarnings("deprecation")
	public static Translate GoogleTranslateService() {

		if (translate == null) {
			translate = TranslateOptions.newBuilder().setApiKey(apiKey).build().getService();
		}
		return translate;
	}

	@SuppressWarnings("deprecation")
	public static void inicializaGoogleTranslateConnection() {
		if (translate == null) {
			translate = TranslateOptions.newBuilder().setApiKey(apiKey).build().getService();
		}
	}

}