package br.com.financial.transacoes.security.controller;

import br.com.financial.transacoes.security.controller.form.LoginForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private static final Logger LOGGER = LogManager.getLogger();


    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid LoginForm loginForm){
        LOGGER.info("email: " + loginForm.getLogin() + " senha: " + loginForm.getSenha());

        return ResponseEntity.status(200).build();
    }
}
