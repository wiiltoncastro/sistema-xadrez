package aplicacao;

import xadrez.PecaDeXadrez;

public class UI {

	public static void imprimirTabuleiro(PecaDeXadrez[][] pecas) {
		
		for(int i = 0; i < pecas.length; i++) {
			System.out.print((8-i) + " ");
			for(int j = 0; j < pecas.length; j++) {
				imprimirPeca(pecas[i][j]);
			}
			System.out.println("");
		}
		System.out.print("  A B C D E F G H");
		
	}
	
	private static void imprimirPeca(PecaDeXadrez peca) {
		if (peca == null) {
			System.out.print("-");
		} else {
			System.out.print(peca);
		}
		System.out.print(" ");
	}
	
}
