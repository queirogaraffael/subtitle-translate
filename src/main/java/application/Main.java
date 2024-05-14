package application;

import GoogleTranslateAPI.GoogleTranslateConnection;
import controller.SubtitleTranslateController;

public class Main {

	public static void main(String[] args) {
		
		GoogleTranslateConnection.inicializaGoogleTranslateConnection();

		SubtitleTranslateController controller = new SubtitleTranslateController();

		controller.MainProgram();

	}
}