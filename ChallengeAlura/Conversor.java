package br.com.alura.ChallengeAlura;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

import java.util.*;

public class Conversor {
    double usd,brl,eur,cny,jpy,cad;
    List<String> conversaoFeitas = new ArrayList<>();


    BuscarNaApi apOk;

    public Conversor(MoedasDaApi m,BuscarNaApi api){
        this.usd = m.usd();
        this.brl = m.brl();
        this.eur = m.eur();
        this.jpy = m.jpy();
        this.cad = m.cad();
        this.cny = m.cny();
        this.apOk = api;

    }
    public String escolhaMoeda(){
        String menu = """
                %nDeseja converter a %s para qual moeda? DIGITE O NOME DA MOEDA!!!
                0 - SAIR;
                1 - USD;
                2 - BRL;
                3 - EUR;
                4 - JPY;
                5 - CAD;
                6 - CNY;
                """.formatted(this.apOk.getMoedaEscolhida());
        System.out.println(menu);
        Scanner leitura = new Scanner(System.in);
        String opcao = leitura.next().toLowerCase();
        return  opcao;
    }

    public void iniciar(){

        conversao(escolhaMoeda(),this.apOk);
    }

    public void conversao(String moedaParaConversao,BuscarNaApi ap) {

        String paraMap = "";
        double valor = 0, valorConvertido = 0;
        boolean continuar = true;

        while (continuar == true) {
            switch (moedaParaConversao) {
                case "usd":

                    moedaParaConversao = conversorMoedas(paraMap,valor,valorConvertido,ap,moedaParaConversao);
                    break;

                case "eur":
                    moedaParaConversao = conversorMoedas(paraMap,valor,valorConvertido,ap,moedaParaConversao);

                    break;

                case "cny":
                    moedaParaConversao =  conversorMoedas(paraMap,valor,valorConvertido,ap,moedaParaConversao);
                    break;

                case "jpy":
                    moedaParaConversao = conversorMoedas(paraMap,valor,valorConvertido,ap,moedaParaConversao);
                    break;

                case "cad":
                    moedaParaConversao = conversorMoedas(paraMap,valor,valorConvertido,ap,moedaParaConversao);
                    break;
                case "brl":
                    moedaParaConversao = conversorMoedas(paraMap,valor,valorConvertido,ap,moedaParaConversao);
                    break;


                case "sair":

                    System.out.println("\nfinalizado");
                    continuar = false;
                    break;

            }

        }
    }

    public void verConversaoFeitas(){
        System.out.println("Suas conversao feitas");
        System.out.println(conversaoFeitas);
    }

    public String conversorMoedas(String paraMap2,double valor2,double valorConvertido2,BuscarNaApi ap2,String moedaConversao2){
        Scanner scan = new Scanner(System.in);
        System.out.println("\ndigite o valor da " + ap2.getMoedaEscolhida() + " para ser convertida em " + moedaConversao2);
        valor2 = scan.nextDouble();
        //valorConvertido2 = valor2 * this.usd;//
        switch (moedaConversao2){
            case "usd": valorConvertido2 = valor2 * this.usd;
                break;
            case "eur": valorConvertido2 = valor2 * this.eur;
                break;
            case "cny": valorConvertido2 = valor2 * this.cny;
                break;
            case "jpy": valorConvertido2 = valor2 * this.jpy;
                break;
            case "cad": valorConvertido2 = valor2 * this.cad;
                break;
            case "brl": valorConvertido2 = valor2 * this.brl;
                break;
        }
        System.out.printf("\no valor em %s é %.2f",moedaConversao2, valorConvertido2);
        paraMap2 = "A moeda %s o valor %.2f em %s é %.2f".formatted(ap2.getMoedaEscolhida(),valor2,moedaConversao2,valorConvertido2);
        conversaoFeitas.add(paraMap2);

        paraMap2="";
        valor2 = 0;
        valorConvertido2 = 0;
        String x;
        moedaConversao2 = escolhaMoeda();
        return x = moedaConversao2;

    }



}





