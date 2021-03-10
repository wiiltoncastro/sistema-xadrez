package xadrez;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca{

	private Cor cor;
	private int contarMovimento;

	//construtor
	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	//gets
	public Cor getCor() {
		return cor;
	}
	
	public int getContarMovimento() {
		return contarMovimento;
	}
	
	//metodos da classe
	public void aumentarContagemMovimento() {
		contarMovimento++;
	}
	
	public void diminuirContagemMovimento() {
		contarMovimento--;
	}
	
	public PosicaoXadrez obterPosicaoXadrez() {
		return PosicaoXadrez.daPosicao(posicao);
	}
	
	
	protected boolean temPecaDoOponente(Posicao posicao) {
		PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
		
	}
}
