package xadrez.pecas;

import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {

	// construtor
	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	// metodos da classe
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		if (getCor() == Cor.BRANCO) {
			// Peão BRANCO
			// uma casa a frente
			p.definirValores(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			// duas casas a frente
			p.definirValores(posicao.getLinha() - 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p) && getTabuleiro().posicaoExiste(p2)
					&& !getTabuleiro().temUmaPeca(p2) && getContarMovimento() == 0) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}

			// diagonal esquerda
			p.definirValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(p) && temPecaDoOponente(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}

			// diagonal direita
			p.definirValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(p) && temPecaDoOponente(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
		} else {
			// Peão PRETO
			// uma casa a frente
			p.definirValores(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			// duas casas a frente
			p.definirValores(posicao.getLinha() + 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p) && getTabuleiro().posicaoExiste(p2)
					&& !getTabuleiro().temUmaPeca(p2) && getContarMovimento() == 0) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}

			// diagonal esquerda
			p.definirValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(p) && temPecaDoOponente(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}

			// diagonal direita
			p.definirValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(p) && temPecaDoOponente(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
		}

		return matriz;
	}

	@Override
	public String toString() {
		return "P";
	}

}
