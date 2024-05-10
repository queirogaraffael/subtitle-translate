package application;

import GoogleTranslateAPI.GoogleTranslateConnection;
import controller.MainProgramController;

public class Main {

	public static void main(String[] args) {
		
		GoogleTranslateConnection.inicializaGoogleTranslateConnection();

		MainProgramController controller = new MainProgramController();

		controller.MainProgram();

	}
}