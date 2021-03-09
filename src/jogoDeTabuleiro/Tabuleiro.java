package jogoDeTabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	// construtor
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new ExcecaoTabuleiro("Erro criando tabuleiro: E nescessario pelo menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	// gets e sets
	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	// metodos da classe
	public Peca peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new ExcecaoTabuleiro("Posicao nao existe no tabuleiro");
		}
		return pecas[linha][coluna];
	}

	public Peca peca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new ExcecaoTabuleiro("Posicao nao existe no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void colocarPeca(Peca peca, Posicao posicao) {
		if (temUmaPeca(posicao)) {
			throw new ExcecaoTabuleiro("Ja existe uma pe�a nessa posicao: " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removerPeca(Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new ExcecaoTabuleiro("Posicao nao existe no tabuleiro.");
		}
		if(peca(posicao) == null) {
			return null;
		}
		Peca auxiliar = peca(posicao);
		auxiliar.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return auxiliar;
		
	}

	private boolean posicaoExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}

	public boolean temUmaPeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new ExcecaoTabuleiro("Posicao nao existe no tabuleiro");
		}
		return peca(posicao) != null;
	}
}
