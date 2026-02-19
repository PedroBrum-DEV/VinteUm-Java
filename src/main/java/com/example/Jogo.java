package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo(){
        monte.embaralhar();
        distribuirCartaParaJogador(new Jogador());
        distribuirCartaParaJogador(new Computador());
    }
    public Carta distribuirCartaParaJogador(Jogador jogador){
        if(jogador.parou()) return null;
     var carta = monte.virar();
     jogador.receberCarta(carta);
     return carta;

    }
   public boolean acabou(){
        var jogadorEstourou = jogador.getPontos() > 21;
        var computadorEStourou = computador.getPontos() > 21;

        if (jogadorEstourou|| computadorEStourou ) return  true;
        if(jogador.parou() && computador.parou())return true;

        return false;
   }
   public String Resultado (){
       var jogadorEstourou = jogador.getPontos() > 21;
       var computadorEStourou = computador.getPontos() > 21;

       if (jogadorEstourou|| computadorEStourou ) return  "Empatou";
       if(jogador.getPontos() == computador.getPontos())return "Empatou";

       if(jogador.getPontos() > computador.getPontos()) return "Voce Ganhou";
       if(computadorEStourou) return "Voce Ganhou";

       return "Voce Perdeu";
   }
}



