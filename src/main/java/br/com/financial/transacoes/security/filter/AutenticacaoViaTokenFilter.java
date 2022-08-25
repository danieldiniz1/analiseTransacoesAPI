package br.com.financial.transacoes.security.filter;

import br.com.financial.transacoes.repository.ClienteRepository;
import br.com.financial.transacoes.security.service.TokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LogManager.getLogger();

    private TokenService tokenService;
    private ClienteRepository clienteRepository;
    private final String PREFIX = "Bearer ";
    public AutenticacaoViaTokenFilter(TokenService tokenService, ClienteRepository clienteRepository) {
        this.tokenService = tokenService;
        this.clienteRepository = clienteRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        boolean tokenValido = tokenService.isTokenValido(token);
        LOGGER.info("O Token é válido? " + tokenValido);

        filterChain.doFilter(request,response);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith(PREFIX)){
            return null;
        }
        return token.substring(7,token.length());
    }
}
