package xadrez;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		configuracaoInicial();
	}
	
	public PecaDeXadrez[][] obterPecas() {
		PecaDeXadrez[][] matriz = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i = 0; i < tabuleiro.getLinhas(); i++) {
			for(int j = 0; j < tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}
		return matriz;
	}
	
	public boolean[][] possiveisMovimentos(PosicaoXadrez posicaoOrigem) {
		Posicao posicao = posicaoOrigem.posicionar();
		validarPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).possiveisMovimentos();
	}
	
	public PecaDeXadrez executarMovimentosDeXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.posicionar();
		Posicao destino = posicaoDestino.posicionar();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Peca pecaCapiturada = fazerMover(origem, destino);
		return (PecaDeXadrez)pecaCapiturada;
	}
	
	private Peca fazerMover(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca pecaCapiturada = tabuleiro.removerPeca(destino);
		tabuleiro.colocarPeca(p, destino);
		return pecaCapiturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if(!tabuleiro.temUmaPeca(posicao)) {
			throw new ExcecaoXadrez("Nao existe peça na posicao de origem.");
		}
		if(!tabuleiro.peca(posicao).existeAlgumMovimentoPossivel()) {
			throw new ExcecaoXadrez("Nao existe movimento possivel para a peca escolhida.");
		}
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if(!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			throw new ExcecaoXadrez("A peca escolhida nao pode ser movida para a posicao de destino.");
		}
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).posicionar());
	}
	
	private void configuracaoInicial() {
		colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));
		
		colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
		
	}
}
