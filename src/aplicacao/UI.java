package aplicacao;



import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class UI {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void limparTela() { 
	 System.out.print("\033[H\033[2J"); 
	 System.out.flush(); 
	} 
	
	public static PosicaoXadrez lerPosicaoXadrez(Scanner sc) {
		try {
		String s = sc.nextLine();
		char coluna = s.charAt(0);
		int linha = Integer.parseInt(s.substring(1));
		return new PosicaoXadrez(coluna, linha);
		}
		catch(RuntimeException e) {
			throw new InputMismatchException("Erro lendo posicao de Xadrez: Valores valido sao de a1 a h8.");
		}
	}
	
	public static void imprimirPartida(PartidaXadrez partidaXadrez, List<PecaXadrez> capturadas) {
		imprimirTabuleiro(partidaXadrez.obterPecas());
		System.out.println("");
		imprimirPecasCapituradas(capturadas);
		System.out.println("");
		System.out.println("Turno: " + partidaXadrez.getTurno());
		if(!partidaXadrez.getCheckMate()) {
				System.out.println("Esperando Jogador: " + partidaXadrez.getJogadorAtual());
				if(partidaXadrez.getCheck()) {
				System.out.println("CHECK!");
			}
		}	
		else {
			System.out.println("CHECKMATE!");
			System.out.println("Vencedor: " + partidaXadrez.getJogadorAtual());
		}
	}
	
	public static void imprimirTabuleiro(PecaXadrez[][] pecas) {

		for (int i = 0; i < pecas.length; i++) {
			System.out.print(ANSI_RED + (8 - i) + " " + ANSI_RESET);
			for (int j = 0; j < pecas.length; j++) {
				imprimirPeca(pecas[i][j], false);
			}
			System.out.println("");
		}
		System.out.print(ANSI_RED + "  A B C D E F G H" + ANSI_RESET);

	}

	private static void imprimirPeca(PecaXadrez peca, boolean backgroud) {
		if(backgroud) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (peca == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if (peca.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_WHITE + peca + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}

	public static void imprimirTabuleiro(PecaXadrez[][] pecas, boolean[][] possiveisMovimentos) {

		for (int i = 0; i < pecas.length; i++) {
			System.out.print(ANSI_RED + (8 - i) + " " + ANSI_RESET);
			for (int j = 0; j < pecas.length; j++) {
				imprimirPeca(pecas[i][j], possiveisMovimentos[i][j]);
			}
			System.out.println("");
		}
		System.out.print(ANSI_RED + "  A B C D E F G H" + ANSI_RESET);

	}
	
	private static void imprimirPecasCapituradas(List<PecaXadrez> capituradas) {
		List<PecaXadrez> branco = capituradas.stream().filter(x -> x.getCor() == Cor.BRANCO).collect(Collectors.toList());
		List<PecaXadrez> preto = capituradas.stream().filter(x -> x.getCor() == Cor.PRETO).collect(Collectors.toList());
		System.out.println("");
		System.out.println("Pecas Capturadas: ");
		System.out.print("Branca:");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(branco.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Preta:");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(preto.toArray()));
		System.out.print(ANSI_RESET);
	}
}
