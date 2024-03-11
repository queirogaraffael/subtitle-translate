package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.Word;
import translationServices.GoogleTranslater;
import translationServices.Translater;

public class Program {

	public static void main(String[] args) {

		Translater translater = new GoogleTranslater();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the path: ");
		String path = scanner.next();

		File path1 = new File(path);
		String pathToSave = path1.getParent();

		List<Word> words = new ArrayList<Word>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			while (line != null) {

				if (!isANumber(line) && !line.contains(" --> ") && !line.isEmpty()) {

					List<String> linha = new ArrayList<String>(Arrays.asList(line.split(" ")));

					for (int i = 0; i < linha.size(); i++) {

						String filteredWord = filter(linha.get(i)).toLowerCase();

						if (filteredWord != "") {
							Word palavra = new Word(filteredWord);
							if (words.contains(palavra)) {
								int index = words.indexOf(palavra);
								words.get(index).setFrequency(1);
							} else {
								words.add(palavra);
								translater.setText(filteredWord);
								palavra.setNameTranslated(translater.getTranslation());

							}
						}

					}

				}
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {

			Collections.sort(words);
			saveFile(pathToSave, words);

			for (Word word : words) {
				System.out.println(word);

			}

			scanner.close();
		}

	}

	public static boolean isANumber(String phrase) {
		try {
			Integer.parseInt(phrase);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static String filter(String WordName) {
		String charactersNotIncluded = "['\"!@ $%¨&*()_+=´`{}\\[\\]^~,.<>:;1234567890\\\\/?-]";

		Pattern pattern = Pattern.compile(charactersNotIncluded);

		Matcher matcher = pattern.matcher(WordName);
		String filteredName = matcher.replaceAll("");

		return filteredName;

	}

	public static void saveFile(String path, List<Word> list) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (Word line : list) {
				bw.write(line.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
