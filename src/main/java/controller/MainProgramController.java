package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import GoogleTranslateAPI.Translator;
import Services.MainProgramService;
import entities.Word;

public class MainProgramController {

	public MainProgramController() {

	}

	public void MainProgram() {

		String path = JOptionPane.showInputDialog("Caminho do arquivo: ");

		File path1 = new File(path);

		List<Word> words = new ArrayList<Word>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String linhaDoArquivo = br.readLine();

			while (linhaDoArquivo != null) {

				if (!MainProgramService.isANumber(linhaDoArquivo) && !linhaDoArquivo.contains(" --> ")
						&& !linhaDoArquivo.isEmpty()) {

					List<String> linha = new ArrayList<String>(Arrays.asList(linhaDoArquivo.split(" ")));

					for (int i = 0; i < linha.size(); i++) {

						String filteredWord = MainProgramService.filter(linha.get(i)).toLowerCase();

						if (!filteredWord.equals("") && !filteredWord.equals(" ")) {
							Word palavra = new Word(filteredWord);

							if (words.contains(palavra)) {
								int index = words.indexOf(palavra);
								words.get(index).adicionaFrequencia();

							} else {

								String translatedWord = Translator.translateText(filteredWord, "pt");
								palavra.setWordTranslated(translatedWord);
								words.add(palavra);

							}
						}

					}

				}
				linhaDoArquivo = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			String pathToSave = path1.getParent();

			String nomeArquivo = path1.getName();

			String nomeArquivoFormatado = nomeArquivo.substring(0, 1).toUpperCase() + nomeArquivo.substring(1);

			Collections.sort(words);
			MainProgramService.saveFile(pathToSave, nomeArquivoFormatado, words);
			JOptionPane.showMessageDialog(null, "Traducao da legenda finalizada!\nDiretorio: " + pathToSave + "\n"
					+ "Nome do arquivo: FrequenciaDePalavras" + nomeArquivoFormatado);

			System.exit(0);

		}

	}
}
