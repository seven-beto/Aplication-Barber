package Aplication.Barber.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity TratamentoErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity TratamentoErro400(MethodArgumentNotValidException ex){
        var erro = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erro.stream().map(DadosErro::new).toList());
    }

    public record DadosErro(String campo, String mensagem){
        public DadosErro (FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

}
