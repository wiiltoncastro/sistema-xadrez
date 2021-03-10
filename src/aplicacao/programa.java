package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ExcecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez p1 = new PartidaXadrez();
		List<PecaXadrez> capturadas = new ArrayList<>();

		while (!p1.getCheckMate()) {
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
				
				PecaXadrez pecaCapturada = p1.executarMovimentosDeXadrez(origem, destino);
				
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
		UI.limparTela();
		UI.imprimirPartida(p1, capturadas);
	}

}
