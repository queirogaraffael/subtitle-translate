package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import Services.MainProgramService;
import entities.Word;

public class MainProgramController {

	public MainProgramController() {

	}

	public void MainProgram() {
		
//pode estar demorando pq ele nao sabe qual o idioma logo
// classe que manipula a adicao de palavras
// dizer qual o idioma da legenda e perguntar para qual ele quer traduzir
// melhoria nos nomes do view
// LOADING
// melhorar a rapidez do programa
// o mainprogram faz de acordo com o idioma escolhido e chama os metodos
		
		String path = JOptionPane.showInputDialog("Digite o caminho do arquivo da legenda: ");

		List<Word> words = new ArrayList<Word>();

		MainProgramService.processarConteudoDoArquivo(words, path);
		
		File path1 = new File(path);
		String pathToSave = path1.getParent();
		String nomeArquivo = path1.getName();

		String nomeArquivoFormatado = nomeArquivo.substring(0, 1).toUpperCase() + nomeArquivo.substring(1);

		Collections.sort(words);
		// e se der erro ? vai chegar aqui e vai salvar ? 
		
		MainProgramService.saveFile(pathToSave, nomeArquivoFormatado, words);
		JOptionPane.showMessageDialog(null, "Traducao da legenda finalizada!\nDiretorio: " + pathToSave + "\n"
				+ "Nome do arquivo: FrequenciaDePalavras" + nomeArquivoFormatado);

		System.exit(0);

	}
}
