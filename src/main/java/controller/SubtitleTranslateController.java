package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import GoogleTranslateAPI.GoogleTranslateConnection;
import Services.SubtitleTranslateService;
import constantes.ConstantesOpcoes;
import entities.Word;
import util.ManipulaArquivo;
import views.FalhaArquivoView;
import views.IdiomasView;
import views.SinalDeEsperaTraducaoView;
import views.TraducaoFinalizadaView;

public class SubtitleTranslateController {

	public SubtitleTranslateController() {

	}

	public void MainProgram() {

		List<Word> words = new ArrayList<Word>();

		String caminhoArquivoLegendaString = JOptionPane.showInputDialog("Digite o caminho do arquivo da legenda: ");

		while (true) {

			if (!ManipulaArquivo.verificaSeArquivoExiste(caminhoArquivoLegendaString)
					|| !ManipulaArquivo.verificarDiretorio(caminhoArquivoLegendaString)) {
				int opcao = FalhaArquivoView.view();

				if (opcao == ConstantesOpcoes.SIM) {
					caminhoArquivoLegendaString = JOptionPane
							.showInputDialog("Digite o caminho do arquivo da legenda: ");

				} else {
					GoogleTranslateConnection.clearTranslateService();
					System.exit(0);
				}

			} else {
				break;
			}

		}

		String idiomaTraduzir = IdiomasView.idiomaParaTraduzir();

		SinalDeEsperaTraducaoView.view();

		SubtitleTranslateService.processarConteudoDoArquivo(words, caminhoArquivoLegendaString, idiomaTraduzir);

		SubtitleTranslateService.organizaPalavrasPelaInterfaceComparable(words);

		String nomeArquivoFormatado = SubtitleTranslateService.formataNomeArquivoTraduzido(caminhoArquivoLegendaString);
		String caminhoParaSalvarArquivoTraduzido = SubtitleTranslateService
				.caminhoParaSalvarArquivoTraduzido(caminhoArquivoLegendaString);

		ManipulaArquivo.salvaArquivoTraducaoFrequencia(caminhoParaSalvarArquivoTraduzido, nomeArquivoFormatado, words);

		TraducaoFinalizadaView.view(caminhoParaSalvarArquivoTraduzido, nomeArquivoFormatado);

		GoogleTranslateConnection.clearTranslateService();
		System.exit(0);

	}

}
