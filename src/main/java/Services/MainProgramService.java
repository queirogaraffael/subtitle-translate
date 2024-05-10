package Services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.Word;

public class MainProgramService {

	public static boolean isANumber(String phrase) {
		try {
			Integer.parseInt(phrase);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

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
		String charactersNotIncluded = "[\"!@ $%¨&*()_+=´`{}\\[\\]^~,.<>:;1234567890\\\\/?-] --> ";

		Pattern pattern = Pattern.compile(charactersNotIncluded);

		Matcher matcher = pattern.matcher(phrase);
		String filteredName = matcher.replaceAll("");

		return filteredName;

	}

// melhorar a fluidez aqui, porque continua muito lento
// separar responsabilidades 
	public static void processarConteudoDoArquivo(List<Word> words, String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String linhaDoArquivo = br.readLine();

			while (linhaDoArquivo != null) {
// utiliza expressao lambda para isso aqui
				if (!linhaDoArquivo.isEmpty()) {

					List<String> linha = new ArrayList<String>(Arrays.asList(linhaDoArquivo.split(" ")));

					for (int i = 0; i < linha.size(); i++) {

						String filteredWord = MainProgramService.filter(linha.get(i)).toLowerCase();

						encontraOuCriaPalavra(filteredWord, words);

					}

				}
				linhaDoArquivo = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void encontraOuCriaPalavra(String filteredWord, List<Word> words) {
		if (!filteredWord.equals("") && !filteredWord.equals(" ")) {
			Word palavra = new Word(filteredWord);

			if (words.contains(palavra)) {
				int index = words.indexOf(palavra);
				words.get(index).adicionaFrequencia();

			} else {

				// String translatedWord = Translator.translateText(filteredWord, "pt");
				// palavra.setWordTranslated(translatedWord);
				words.add(palavra);

			}
		}
	}
}
