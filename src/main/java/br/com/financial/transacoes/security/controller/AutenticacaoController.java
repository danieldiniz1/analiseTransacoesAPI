package br.com.financial.transacoes.security.controller;

import br.com.financial.transacoes.security.controller.dto.TokenDTO;
import br.com.financial.transacoes.security.controller.form.LoginForm;
import br.com.financial.transacoes.security.service.TokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid LoginForm loginForm){
        LOGGER.info("email: " + loginForm.getLogin() + " senha: " + loginForm.getSenha());
        UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();

        try {
            Authentication authenticate = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authenticate);
            LOGGER.info("Token: " + token);
            return ResponseEntity.status(HttpStatus.OK).body(TokenDTO.of(token,"Bearer"));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}
