package xadrez;

import jogoDeTabuleiro.Posicao;

public class PosicaoXadrez {

	private char coluna;
	private int linha;
	
	//construtor
	public PosicaoXadrez(char coluna, int linha) {
		if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new ExcecaoXadrez("Erro criando Posição de Xadrez: Valores validos de a1 à h8.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	//gets
	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}
	
	//metodos da classe
	protected Posicao posicionar() {
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	protected static PosicaoXadrez daPosicao(Posicao posicao) {
		return new PosicaoXadrez((char)('a' + posicao.getColuna()), 8 - posicao.getLinha());
	}

	//toString
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	
	
}
