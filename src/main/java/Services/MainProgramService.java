package Services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import GoogleTranslateAPI.Translator;
import entities.Word;

public class MainProgramService {

	public static void saveFile(String caminhoArquivo, String nomeArquivo, List<Word> palavras) {

		File diretorio = new File(caminhoArquivo);

		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}

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

	public static String filter(String phrase) {
		String charactersNotIncluded = "[\"!@ $%¨&*()_+=´`{}\\[\\]^~,.<>:;1234567890\\\\/?-]";

		Pattern pattern = Pattern.compile(charactersNotIncluded);

		Matcher matcher = pattern.matcher(phrase);
		String filteredName = matcher.replaceAll("");

		return filteredName;

	}

// melhorar a fluidez aqui, 
// separar responsabilidades 
	public static void processarConteudoDoArquivo(List<Word> words, String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String linhaDoArquivo = br.readLine();

			while (linhaDoArquivo != null) {
// utiliza expressao lambda para isso aqui
				if (!linhaDoArquivo.contains(" --> ") && !linhaDoArquivo.isEmpty()) {

					String[] linha = linhaDoArquivo.split(" ");

					for (int i = 0; i < linha.length; i++) {
						String filteredWord = MainProgramService.filter(linha[i].toLowerCase());
						encontraOuCriaPalavra(filteredWord, words);
					}
				}
				linhaDoArquivo = br.readLine();
			}
		} catch (IOException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar ler arquivo." + erro);
		}
	}

// melhorar mais - separar a classe de tradução
	private static void encontraOuCriaPalavra(String filteredWord, List<Word> words) {
		if (!filteredWord.equals("") && !filteredWord.equals(" ")) {
			Word palavra = new Word(filteredWord);

			if (words.contains(palavra)) {
				int index = words.indexOf(palavra);
				words.get(index).adicionaFrequencia();
			} else {
				String translatedWord = Translator.translateText(filteredWord, "en", "pt");
				palavra.setWordTranslated(translatedWord);
				words.add(palavra);
			}
		}
	}

	public static String formataNomeArquivoTraduzido(String caminhoArquivoLegendaString) {
		File caminhoArquivoLegenda = new File(caminhoArquivoLegendaString);
		String nomeArquivo = caminhoArquivoLegenda.getName();

		String nomeArquivoFormatado = nomeArquivo.substring(0, 1).toUpperCase() + nomeArquivo.substring(1);

		return nomeArquivoFormatado;
	}

	public static String caminhoParaSalvarArquivoTraduzido(String caminhoArquivoLegendaString) {
		File caminhoArquivoLegenda = new File(caminhoArquivoLegendaString);
		return caminhoArquivoLegenda.getParent();
	}

	public static void organizaPalavrasPelaInterfaceComparable(List<Word> words) {
		Collections.sort(words);

	}
}
