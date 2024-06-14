package commons.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import commons.constantes.ConstantesGeral;
import model.entities.Word;

public class FileManager {

	public static boolean retornaSeDiretorioEValido(String caminhoArquivoLegendaString) throws IOException {
		File caminhoArquivoLegenda = new File(caminhoArquivoLegendaString);
		File diretorio = caminhoArquivoLegenda.getParentFile();

		if (diretorio == null || !diretorio.exists() || !diretorio.isDirectory()) {
			return false;
		}

		File testeArquivo = new File(diretorio, "teste.srt");
		try {
			if (!testeArquivo.createNewFile()) {
				return false;
			}
			return testeArquivo.delete();
		} catch (IOException e) {
			return false;
		}
	}

	public static boolean verificaSeArquivoExiste(String caminhoArquivo) {
		return new File(caminhoArquivo).exists();
	}

	public static void salvaArquivoTraducaoFrequencia(String caminhoArquivo, String nomeArquivo, List<Word> palavras)
			throws IOException {
		File diretorio = new File(caminhoArquivo);
		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}

		File arquivo = new File(diretorio, ConstantesGeral.nomeArquivoFinal + nomeArquivo);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
			for (Word palavra : palavras) {
				bw.write(palavra.toString());
				bw.newLine();
			}
		}
	}

	public static void processarPalavrasDoArquivoDeLegenda(List<Word> words, String caminhoArquivoLegenda)
			throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoLegenda))) {
			String linhaDoArquivo;
			while ((linhaDoArquivo = br.readLine()) != null) {
				if (!linhaDoArquivo.contains(" --> ") && !linhaDoArquivo.isEmpty()) {
					String[] linha = linhaDoArquivo.split(" ");
					for (String palavra : linha) {
						String palavraFiltrada = FiltroDeCaracteresEspeciais.filter(palavra.toLowerCase());
						if (!palavraFiltrada.isEmpty()) {
							Word palavraObj = new Word(palavraFiltrada);
							int index = words.indexOf(palavraObj);
							if (index >= 0) {
								words.get(index).adicionaFrequencia();
							} else {
								words.add(palavraObj);
							}
						}
					}
				}
			}
		}
	}

	public static String formataNomeArquivoTraduzido(String caminhoArquivoLegendaString) {
		File caminhoArquivoLegenda = new File(caminhoArquivoLegendaString);
		String nomeArquivo = caminhoArquivoLegenda.getName();
		return Character.toUpperCase(nomeArquivo.charAt(0)) + nomeArquivo.substring(1);
	}

	public static String caminhoParaSalvarArquivoTraduzido(String caminhoArquivoLegendaString) {
		return new File(caminhoArquivoLegendaString).getParent();
	}
}
