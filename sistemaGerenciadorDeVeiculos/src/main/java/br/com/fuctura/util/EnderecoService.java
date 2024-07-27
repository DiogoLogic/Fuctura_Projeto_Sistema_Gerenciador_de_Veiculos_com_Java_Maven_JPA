package br.com.fuctura.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.fuctura.execeptions.CepInvalidoException;
import br.com.fuctura.model.entidades.Endereco;


public class EnderecoService {
    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/%s/json/";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public Endereco buscarEnderecoPorCep(String cep) throws CepInvalidoException, IOException {
        if (cep == null || cep.isEmpty()) {
            throw new IllegalArgumentException("CEP não pode ser nulo ou vazio.");
        }

        String cepLimpo = cep.replaceAll("[^0-9]", "");

        if (!cepLimpo.matches("\\d{8}")) {
            throw new CepInvalidoException("Formato de CEP inválido.");
        }

        try {
            HttpResponse<String> response = fazerRequisicao(cepLimpo);

            if (response.statusCode() == 200) {
                JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

                if (jsonObject.has("erro") && jsonObject.get("erro").getAsBoolean()) {
                    throw new CepInvalidoException("CEP não encontrado.");
                } else {
                    Endereco endereco = gson.fromJson(response.body(), Endereco.class);
                    endereco.setCep(cepLimpo);
                    return endereco;
                }
            } else {
                throw new IOException("Erro na requisição à API ViaCEP. Código de status: " + response.statusCode());
            }
        } catch (URISyntaxException | InterruptedException e) {
            throw new RuntimeException("Erro na requisição: " + e.getMessage(), e);
        }
    }

    private HttpResponse<String> fazerRequisicao(String cep) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(String.format(VIA_CEP_URL, cep)))
                .header("Accept", "application/json")
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
