package model.exceptions;


// Os erros tratados aqui estão vindo da entidade de dominio (entities.reservation)


// A classe pode extender de RuntimeException ou Exception
// RuntimeException: Tipo de excessão que o compilador NÃO obriga a tratar
// Exception: O compilador obriga a tratar
public class DomainException extends Exception{

    // Permite instânciar a excessão personalizada recebendo uma mensagem
    public DomainException(String msg) {
        super(msg); // repassa a mensagem para o construtor da superclasse
    }
}
