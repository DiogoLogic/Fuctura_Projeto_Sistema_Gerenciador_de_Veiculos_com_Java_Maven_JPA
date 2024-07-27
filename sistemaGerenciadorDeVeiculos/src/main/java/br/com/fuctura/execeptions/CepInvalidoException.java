package br.com.fuctura.execeptions;



@SuppressWarnings("serial")
public class CepInvalidoException extends Exception {
    public CepInvalidoException(String message) {
        super(message);
    }
}
