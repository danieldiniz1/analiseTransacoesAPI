package br.com.financial.transacoes.security.controller.dto;

public class TokenDTO {
    private String token;
    private String tipo;

    public TokenDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TokenDTO(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public static TokenDTO of(String token, String tipo){
        return new TokenDTO(token,tipo);
    }
}
