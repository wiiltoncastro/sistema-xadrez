package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;

public class programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez p1 = new PartidaXadrez();

		while (true) {
			UI.imprimirTabuleiro(p1.obterPecas());
			System.out.println();
			System.out.print("Posicao Origem: ");
			PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
			
			System.out.println();
			System.out.print("Posicao Destino: ");
			PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
			
			PecaDeXadrez pecaCapturada = p1.executarMovimentosDeXadrez(origem, destino);
			
		}
	}

}
