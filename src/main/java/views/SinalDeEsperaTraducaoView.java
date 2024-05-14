package views;

import javax.swing.JOptionPane;

public class SinalDeEsperaTraducaoView {
	public static void view() {
		JOptionPane.showMessageDialog(null, "Clique em OK e espera o processamento ser finalizado!",
				"O tempo depende do tamanho do arquivo!", JOptionPane.WARNING_MESSAGE);
	}
}
