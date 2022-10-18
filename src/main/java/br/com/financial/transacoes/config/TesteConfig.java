package br.com.financial.transacoes.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TesteConfig {

    private static final Logger LOGGER = LogManager.getLogger();


}
