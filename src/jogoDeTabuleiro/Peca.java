package jogoDeTabuleiro;

public class Peca {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	//construtor
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.posicao = null;
	}

	//get
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
}
