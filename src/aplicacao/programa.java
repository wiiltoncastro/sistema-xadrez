package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ExcecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;

public class programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez p1 = new PartidaXadrez();
		List<PecaDeXadrez> capturadas = new ArrayList<>();

		while (true) {
			try {
				UI.limparTela();
				UI.imprimirPartida(p1, capturadas);
				System.out.println("");
				System.out.println("");
				System.out.print("Posicao Origem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
				
				boolean[][] possiveisMovimentos = p1.possiveisMovimentos(origem);
				UI.limparTela();
				UI.imprimirTabuleiro(p1.obterPecas(), possiveisMovimentos);
				
				System.out.println("");
				System.out.println("");
				System.out.print("Posicao Destino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
				
				PecaDeXadrez pecaCapturada = p1.executarMovimentosDeXadrez(origem, destino);
				
				if(pecaCapturada != null) {
					capturadas.add(pecaCapturada);
				}
			} 
			catch (ExcecaoXadrez e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
