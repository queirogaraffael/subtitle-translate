package views;

import javax.swing.JOptionPane;

public class TraducaoFinalizadaView {
	public static void view(String caminhoParaSalvarArquivoTraduzido, String nomeArquivoFormatado) {
		JOptionPane
				.showMessageDialog(null,
						"Diretorio: " + caminhoParaSalvarArquivoTraduzido + "\n"
								+ "Nome do arquivo: FrequenciaDePalavras" + nomeArquivoFormatado,
						"Traducao da legenda finalizada!", JOptionPane.INFORMATION_MESSAGE);
	}
}
