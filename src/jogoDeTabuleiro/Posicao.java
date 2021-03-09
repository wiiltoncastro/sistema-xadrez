package jogoDeTabuleiro;

public class Posicao {

	private int linha;
	private int coluna;
	
	//construtor
	public Posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	//gets e sets
	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public void definirValores(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	//toString
	@Override
	public String toString() {
		return linha + "," + coluna;
	}
	
}
