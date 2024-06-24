package br.com.alura.ChallengeAlura;

public class MoedaNaoAceitaException extends RuntimeException{


    public String moedaInvalidaException(){
        return ("Digite o nome da moeda e nao numeros!! E A KPW moeda norte koerana nao é aceita!"
                + " vc digitou: " );
    }
}
