package views;

import javax.swing.JOptionPane;

import commons.constantes.ConstantesGeral;

public class TraducaoFinalizadaView {
	public static void view(String caminhoParaSalvarArquivoTraduzido, String nomeArquivoFormatado) {
		JOptionPane.showMessageDialog(null,
				"Diretorio: " + caminhoParaSalvarArquivoTraduzido + "\n" + "Nome do arquivo: "
						+ ConstantesGeral.nomeArquivoFinal + nomeArquivoFormatado,
				"Traducao da legenda finalizada!", JOptionPane.INFORMATION_MESSAGE);
	}
}
