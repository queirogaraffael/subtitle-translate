package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import constantes.ConstantesGeral;
import entities.Word;

public class ManipulacoesArquivo {
	
	public static boolean retornaSeDiretorioEValido(String caminhoArquivoLegendaString) throws IOException {

		File caminhoArquivoLegenda = new File(caminhoArquivoLegendaString);

		String caminhoDiretorio = caminhoArquivoLegenda.getParent();

		File diretorio = new File(caminhoDiretorio);

		if (!diretorio.exists() || !diretorio.isDirectory()) {
			return false;
		}

		try {
			File testeArquivo = new File(diretorio, "teste.srt");
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

	public static void salvaArquivoTraducaoFrequencia(String caminhoArquivo, String nomeArquivo, List<Word> palavras)
			throws IOException {

		File diretorio = new File(caminhoArquivo);

		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}

		File arquivo = new File(diretorio, ConstantesGeral.nomeArquivoFinal + nomeArquivo);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
			for (Word line : palavras) {
				bw.write(line.toString());
				bw.newLine();
			}
		}
	}
}
