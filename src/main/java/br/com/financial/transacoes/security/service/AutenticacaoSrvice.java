package br.com.financial.transacoes.security.service;

import br.com.financial.transacoes.model.Cliente;
import br.com.financial.transacoes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AutenticacaoSrvice implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        if (cliente.isEmpty()){
            throw new UsernameNotFoundException("dados inválidos para o usuário com email: " + email);
        }
        return cliente.get();
    }
}
