package views;

import javax.swing.JOptionPane;

import constantes.IdiomasConstantes;

public class IdiomasViews {
	private static Object[] idiomas = { "Ingles", "Portugues", "Alemao" };

	public static String idiomaOriginal() {
		int idioma = JOptionPane.showOptionDialog(null, "Qual o idioma original do arquivo ? ", "Opcao",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, idiomas, idiomas[0]);
		if (idioma == 0) {
			return IdiomasConstantes.INGLES;
		} else if (idioma == 1) {
			return IdiomasConstantes.PORTUGUES;

		} else {
			return IdiomasConstantes.ALEMAO;
		}
	}

	public static String idiomaParaTraduzir() {
		int idioma = JOptionPane.showOptionDialog(null, "Para qual idioma deseja traduzir ? ", "Opcao",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, idiomas, idiomas[0]);

		if (idioma == 0) {
			return IdiomasConstantes.INGLES;
		} else if (idioma == 1) {
			return IdiomasConstantes.PORTUGUES;

		} else {
			return IdiomasConstantes.ALEMAO;
		}
	}

}
