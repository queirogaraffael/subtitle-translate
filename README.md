# Tradutor de Legendas

Este é um tradutor de legendas que permite a tradução de palavras em arquivos de legendas de vídeo (.srt). O projeto utiliza a API do Google Translate para realizar as traduções de um idioma qualquer(que tenha suporte no google tradutor) e permite traduzir para o inglês, portugues ou alemão.

* Focado em leitura de arquivos de legendas no formato .srt.
* Filtragem de palavras válidas.
* Análise da frequência das palavras.
* Tradução das palavras utilizando a API do Google Translate.
* Geração de um novo arquivo de legendas com as palavras e suas traduções, listadas em ordem de frequência das palavras mais frequentes.

## Pré-requisitos
* Para utilizar este projeto, você precisa ter uma conta no Google Cloud e uma chave de API válida para a API do Google Translate.

## Arquitetura MVC
O projeto segue uma arquitetura Modelo-Visão-Controlador (MVC). 
Aqui está uma breve descrição de cada componente:
* Modelo: Responsável pelo processamento dos dados, incluindo a leitura e filtragem das legendas, análise de frequência de palavras, e chamadas para a API do Google Translate.
* Visão: Responsável pela interação com o usuário, exibindo informações e solicitando entradas quando necessário.
* Controlador: Responsável por coordenar as interações entre o Modelo e a Visão, controlando o fluxo de dados e processos.

## Configuração da Chave da API do Google Translate
Para configurar a chave da API do Google Translate, você precisará adicionar a chave ao atributo apiKey da classe GoogleTranslateConnection.
Como usar
* Clone este repositório para o seu ambiente local.
* Configure sua chave de API do Google Translate na classe GoogleTranslateConnection.
* Execute o programa principal.
* Selecione o arquivo de legenda que deseja traduzir. O programa identificara automaticamente o idioma do arquivo.
* Selecione para qual idioma deseja traduzir. 
* Aguarde enquanto o programa processa e traduz as legendas.
* O novo arquivo de legenda traduzido será gerado na mesma pasta do arquivo original.

## Contribuição
Contribuições são bem-vindas! Se você deseja contribuir com melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença
Este projeto é licenciado sob a Licença MIT.
