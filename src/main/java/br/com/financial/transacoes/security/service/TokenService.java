package br.com.financial.transacoes.security.service;

import br.com.financial.transacoes.model.Cliente;
import br.com.financial.transacoes.model.Transacao;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class TokenService {

    @Value("${transacao.jwt.expiration}")
    private String expiration;

    @Value("${transacao.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Cliente cliente = (Cliente) authentication.getPrincipal();
        Date dataInicialToken = Date.valueOf(LocalDate.now());
        Date dataExpiracao = new Date(dataInicialToken.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("Token para autorização na API de transacao")
                .setSubject(cliente.getId().toString())
                .setIssuedAt(dataInicialToken)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
}
