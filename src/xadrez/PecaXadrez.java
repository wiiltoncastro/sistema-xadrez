package xadrez;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca{

	private Cor cor;

	//construtor
	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	//get
	public Cor getCor() {
		return cor;
	}
	
	//metodos da classe
	public PosicaoXadrez obterPosicaoXadrez() {
		return PosicaoXadrez.daPosicao(posicao);
	}
	
	
	protected boolean temPecaDoOponente(Posicao posicao) {
		PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
		
	}
}
