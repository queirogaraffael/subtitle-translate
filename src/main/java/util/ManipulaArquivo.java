package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entities.Word;

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
	
	public static void saveFile(String caminhoArquivo, String nomeArquivo, List<Word> palavras) {

		File diretorio = new File(caminhoArquivo);

		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}
// melhorar isso aqui - integrar mais ao view la
		// criar uma constante para esse nome
		File arquivo = new File(diretorio, "FrequenciaDePalavras" + nomeArquivo);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
			for (Word line : palavras) {
				bw.write(line.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
