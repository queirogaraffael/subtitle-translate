package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import GoogleTranslateAPI.GoogleTranslateConnection;
import Services.SubtitleTranslateService;
import constantes.ConstanteSeQuerContinuarOuNao;
import entities.Word;
import util.ManipulaArquivo;
import views.IdiomasViews;
import views.SeCaminhoArquivoFalharView;
import views.SinalDeEsperaTraducaoView;
import views.TraducaoFinalizadaView;

public class SubtitleTranslateController {

	public SubtitleTranslateController() {

	}

	// analisar a opcao de identificar o idioma automaticamente
	public void MainProgram() {

		String idiomaOriginal = IdiomasViews.idiomaOriginal();

		String caminhoArquivoLegendaString = JOptionPane.showInputDialog("Digite o caminho do arquivo da legenda: ");

		while (true) {

			if (!ManipulaArquivo.verificaSeArquivoExiste(caminhoArquivoLegendaString)
					|| !ManipulaArquivo.verificarDiretorio(caminhoArquivoLegendaString)) {
				int opcao = SeCaminhoArquivoFalharView.view();

				if (opcao == ConstanteSeQuerContinuarOuNao.SIM) {
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

		String idiomaTraduzir = IdiomasViews.idiomaParaTraduzir();

		programa(caminhoArquivoLegendaString, idiomaOriginal, idiomaTraduzir);

	}

	private static void programa(String caminhoArquivoLegendaString, String idiomaOriginal, String idiomaTraduzir) {

		List<Word> words = new ArrayList<Word>();

		SinalDeEsperaTraducaoView.view();

		SubtitleTranslateService.processarConteudoDoArquivo(words, caminhoArquivoLegendaString, idiomaOriginal,
				idiomaTraduzir);

		String nomeArquivoFormatado = SubtitleTranslateService.formataNomeArquivoTraduzido(caminhoArquivoLegendaString);

		String caminhoParaSalvarArquivoTraduzido = SubtitleTranslateService
				.caminhoParaSalvarArquivoTraduzido(caminhoArquivoLegendaString);

		SubtitleTranslateService.organizaPalavrasPelaInterfaceComparable(words);

		ManipulaArquivo.saveFile(caminhoParaSalvarArquivoTraduzido, nomeArquivoFormatado, words);

		TraducaoFinalizadaView.view(caminhoParaSalvarArquivoTraduzido, nomeArquivoFormatado);

		GoogleTranslateConnection.clearTranslateService();
		System.exit(0);

	}
}
