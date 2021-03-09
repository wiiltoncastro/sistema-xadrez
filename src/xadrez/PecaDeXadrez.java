package xadrez;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Tabuleiro;

public class PecaDeXadrez extends Peca{

	private Cor cor;

	//construtor
	public PecaDeXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	//get
	public Cor getCor() {
		return cor;
	}
	
}
