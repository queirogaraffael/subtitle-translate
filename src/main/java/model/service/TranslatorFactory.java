package model.service;

import GoogleAPI.GoogleTranslateConnection;
import model.service.imp.GoogleTranslator;

public class TranslatorFactory {
	public static TranslatorInterface createTranslator() throws Exception {

		return new GoogleTranslator(GoogleTranslateConnection.GoogleTranslateService());

	}
}
