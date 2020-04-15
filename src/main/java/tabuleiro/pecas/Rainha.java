package tabuleiro.pecas;

import Xadrez.Cores;
import tabuleiro.Tabuleiro;

public class Rainha extends Xadrez.PecaXadrez {
    
    public Rainha(Tabuleiro tabuleiro, Cores cor) {
        super(tabuleiro, cor);
    }
    
    @Override
    public String toString() {       
      return "R";                  
    }    
    
    
}