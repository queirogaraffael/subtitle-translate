package Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import GoogleTranslateAPI.Translator;
import entities.Word;

public class SubtitleTranslateService {

	public static String filter(String phrase) {
		String charactersNotIncluded = "[\"!@ $%¨&*()_+=´`{}\\[\\]^~,.<>:;1234567890\\\\/?-]";

		Pattern pattern = Pattern.compile(charactersNotIncluded);

		Matcher matcher = pattern.matcher(phrase);
		String filteredName = matcher.replaceAll("");

		return filteredName;

	}

	public static void processarConteudoDoArquivo(List<Word> words, String caminhoArquivoLegenda, String idiomaTraduzir)
			throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoLegenda))) {

			String linhaDoArquivo = br.readLine();

			while (linhaDoArquivo != null) {

				if (!linhaDoArquivo.contains(" --> ") && !linhaDoArquivo.isEmpty()) {

					String[] linha = linhaDoArquivo.split(" ");

					for (int i = 0; i < linha.length; i++) {
						String palavraFiltrada = SubtitleTranslateService.filter(linha[i].toLowerCase());
						encontraOuCriaPalavra(palavraFiltrada, words, idiomaTraduzir);
					}
				}

				linhaDoArquivo = br.readLine();
			}
		}
	}

	private static void encontraOuCriaPalavra(String palavraFiltrada, List<Word> words, String idiomaTraduzir) {
		if (!palavraFiltrada.equals("") && !palavraFiltrada.equals(" ")) {
			Word palavra = new Word(palavraFiltrada);

			if (words.contains(palavra)) {
				int index = words.indexOf(palavra);
				words.get(index).adicionaFrequencia();
			} else {
				String translatedWord = Translator.tradutorPalavra(palavraFiltrada, idiomaTraduzir);
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
