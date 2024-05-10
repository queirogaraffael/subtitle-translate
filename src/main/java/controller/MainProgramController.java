package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Services.MainProgramService;
import entities.Word;
import util.ManipulaArquivo;
import views.SinalEsperaDeTraducaoView;
import views.TraducaoFinalizadaView;

public class MainProgramController {

	public MainProgramController() {

	}

	public void MainProgram() {

		while (true) {

			String caminhoArquivoLegendaString = JOptionPane
					.showInputDialog("Digite o caminho do arquivo da legenda: ");

			
			System.out.println(ManipulaArquivo.verificaSeArquivoExiste(caminhoArquivoLegendaString));
			System.out.println(ManipulaArquivo.verificarDiretorio(caminhoArquivoLegendaString));
			if (ManipulaArquivo.verificaSeArquivoExiste(caminhoArquivoLegendaString)
					&& ManipulaArquivo.verificarDiretorio(caminhoArquivoLegendaString)) {
				List<Word> words = new ArrayList<Word>();

				SinalEsperaDeTraducaoView.view();

				MainProgramService.processarConteudoDoArquivo(words, caminhoArquivoLegendaString);

				String nomeArquivoFormatado = MainProgramService
						.formataNomeArquivoTraduzido(caminhoArquivoLegendaString);

				String caminhoParaSalvarArquivoTraduzido = MainProgramService
						.caminhoParaSalvarArquivoTraduzido(caminhoArquivoLegendaString);

				MainProgramService.organizaPalavrasPelaInterfaceComparable(words);

				MainProgramService.saveFile(caminhoParaSalvarArquivoTraduzido, nomeArquivoFormatado, words);

				TraducaoFinalizadaView.view(caminhoParaSalvarArquivoTraduzido, nomeArquivoFormatado);

				System.exit(0);

			} else {
				Object[] opcoes = { "Sim", "Nao" };
				int opcao = JOptionPane.showOptionDialog(null, "Deseja tentar outro arquivo ?", "Erro",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
// constantes
				if (opcao == 1) {
					System.exit(0);
				}

			}

		}

	}
}
