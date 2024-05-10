package util;

import java.io.File;
import java.io.IOException;

public class ManipulaArquivo {
	public static boolean verificarDiretorio(String caminhoArquivoLegendaString) {

		File caminhoArquivoLegenda = new File(caminhoArquivoLegendaString);

		String caminhoDiretorio = caminhoArquivoLegenda.getParent();

		File diretorio = new File(caminhoDiretorio);

		if (!diretorio.exists() || !diretorio.isDirectory()) {
			return false;
		}

		try {
			File testeArquivo = new File(diretorio, "teste.txt");
			if (!testeArquivo.createNewFile()) {
				return false;
			} else {
				testeArquivo.delete();
			}
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	public static boolean verificaSeArquivoExiste(String caminhoArquivo) {

		File file = new File(caminhoArquivo);

		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
}
