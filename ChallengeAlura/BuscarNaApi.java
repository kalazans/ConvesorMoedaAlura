package br.com.alura.ChallengeAlura;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscarNaApi {
    private  String moedaEscolhida;


    public String getMoedaEscolhida() {
        return moedaEscolhida;
    }

    public  String buscarNaApiJ(){
        String jsonApi="";
        String menu = """
                \nDigite o nome da moeda base!!!
                0 - SAIR;
                1 - USD;
                2 - BRL;
                3 - EUR;
                4 - JPY;
                5 - CAD;
                6 - CNY;
                """;
        try {
            String chave = "de8277efdd701faff17c550c";
            Scanner scan = new Scanner(System.in);
            System.out.println(menu);
            String moeda = scan.next();
            this.moedaEscolhida = moeda.toLowerCase();
            moeda = moeda.toLowerCase();
            String regex = "usd|brl|eur|jpy|cad|cny";
            Boolean error = false;


                if (moeda.matches(regex)) {
                    String endereço = "https://v6.exchangerate-api.com/v6/" + chave + "/latest/" + moeda;

                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereço)).build();
                    HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());
                    //System.out.println(resposta.body());//
                    jsonApi = resposta.body().toLowerCase();
                }   else {
                    throw new RuntimeException("Digite o nome da moeda e nao numeros!! E A KPW moeda norte koerana nao é aceita!"    + " vc digitou: "+moeda);

                }

                }   catch(IOException | InterruptedException|NullPointerException e ){
                        System.out.println("error na busca na api!! ou sua net esta ruim ou a api esta fora do ar");
                        System.out.println(e.getMessage());
                        buscarNaApiJ();
                }   catch (RuntimeException e ){
                        System.out.println(e.getMessage());
                        buscarNaApiJ();
                }


        return jsonApi;
        }


        public  MoedasDaApi extraitObjetoJson(){
        Gson gs = new Gson();


        JsonObject json = gs.fromJson(buscarNaApiJ(), JsonObject.class);
        JsonObject jsonMoedas =  json.getAsJsonObject("conversion_rates");
        MoedasDaApi moedasRecord = gs.fromJson(jsonMoedas, MoedasDaApi.class);
        return moedasRecord;
        }
}
