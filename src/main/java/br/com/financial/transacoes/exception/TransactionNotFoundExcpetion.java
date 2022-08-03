package br.com.financial.transacoes.exception;

public class TransactionNotFoundExcpetion extends RuntimeException{

    public TransactionNotFoundExcpetion() {
    }

    public TransactionNotFoundExcpetion(String mensagem){
        super(mensagem);
    }
}
