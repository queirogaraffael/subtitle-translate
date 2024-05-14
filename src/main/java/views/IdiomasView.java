package views;

import javax.swing.JOptionPane;

import constantes.ConstantesIdiomas;

public class IdiomasView {
	private static Object[] idiomas = { "Ingles", "Portugues", "Alemao" };

	public static String idiomaParaTraduzir() {
		int idioma = JOptionPane.showOptionDialog(null, "Para qual idioma deseja traduzir ? ", "Opcao",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, idiomas, idiomas[0]);

		return conversorTipoIdioma(idioma);
	}

	private static String conversorTipoIdioma(int idioma) {
		if (idioma == 0) {
			return ConstantesIdiomas.INGLES;
		} else if (idioma == 1) {
			return ConstantesIdiomas.PORTUGUES;

		} else {
			return ConstantesIdiomas.ALEMAO;
		}
	}

}
