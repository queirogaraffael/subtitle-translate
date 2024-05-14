package views;

import javax.swing.JOptionPane;

public class SeCaminhoArquivoFalharView {
	public static int view() {
		Object[] opcoes = { "Sim", "Nao" };
		int opcao = JOptionPane.showOptionDialog(null, "Deseja tentar outro arquivo ?", "Erro",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
		return opcao;
	}
}
