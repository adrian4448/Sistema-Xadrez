package Xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import tabuleiro.pecas.Bispo;
import tabuleiro.pecas.Cavalo;
import tabuleiro.pecas.Peao;
import tabuleiro.pecas.Rainha;
import tabuleiro.pecas.Rei;
import tabuleiro.pecas.Torre;
import tabuleiro.tabuleiroException;
import tabuleiro.Peca;

public class PartidaXadrez {
  
    private Tabuleiro tabuleiro;
    
    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8,8);
        iniciarPartida();
    }
    
    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for(int j = 0; j < tabuleiro.getColunas(); j++){
                mat[i][j] = (PecaXadrez)tabuleiro.peca(i, j);
            }
        }
        return mat;
    }
    
    public PecaXadrez movimentoPeca(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
        
        Posicao origem = posicaoOrigem.toPosition();
        Posicao destino = posicaoDestino.toPosition();
        
        validateOrigemPosition(origem); 
        validateDestinoPosition(origem,destino);
        
        Peca pecaCapturada = fazerMovimento(origem,destino);
                        
        return (PecaXadrez)pecaCapturada;
        
    }
    
    private Peca fazerMovimento(Posicao origem, Posicao destino) {
        Peca p = tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocarPeca(p, destino);
        return pecaCapturada;
    }
    
    public void validateOrigemPosition(Posicao posicao) {
        if(!tabuleiro.PecaExistente(posicao)) {
            throw new tabuleiroException("Nao existe peca na posicao de origem");
        }
        if(!tabuleiro.peca(posicao).verificandoMovimento()) {
            throw new tabuleiroException("Não existe movimentos possiveis para a peça escolhida");
        }
       
    }
    
    public void validateDestinoPosition(Posicao origem, Posicao destino) {
        if(!tabuleiro.peca(origem).movimentoPossivel(destino)) {
            throw new tabuleiroException("A peça escolhida não pode se mover para a peça de destino");
        }
    }
    
    private void NovaPeca(char coluna, int linha, PecaXadrez peca) {
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna,linha).toPosition());
    }
    
    private void iniciarPartida() {
        
        
        NovaPeca('b',3, new Torre(tabuleiro, Cores.BRANCO));
          
    }
    
}
