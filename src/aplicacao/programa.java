package aplicacao;

import xadrez.PartidaXadrez;

public class programa {

	public static void main(String[] args) {

		PartidaXadrez p1 = new PartidaXadrez();
		
		UI.imprimirTabuleiro(p1.obterPecas());
		
	}

}
