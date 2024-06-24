package br.com.alura.ChallengeAlura;

public class Main {
        public static void main(String[] args) {
            BuscarNaApi api = new BuscarNaApi();
            Conversor c = new Conversor(api.extraitObjetoJson(),api);
            c.iniciar();
            c.verConversaoFeitas();
        }
    }
