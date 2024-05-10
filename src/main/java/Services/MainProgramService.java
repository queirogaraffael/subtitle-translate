package Services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		String charactersNotIncluded = "[\"!@ $%¨&*()_+=´`{}\\[\\]^~,.<>:;1234567890\\\\/?-]";

		Pattern pattern = Pattern.compile(charactersNotIncluded);

		Matcher matcher = pattern.matcher(phrase);
		String filteredName = matcher.replaceAll("");

		return filteredName;

	}
}
