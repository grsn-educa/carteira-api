package br.com.alura.carteira.infra;

import br.com.alura.carteira.dto.Erro500Dto;
import br.com.alura.carteira.dto.Erro400Dto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentodeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public List<Erro400Dto> tratarErro400(MethodArgumentNotValidException ex) {
        return ex
                .getFieldErrors()
                .stream()
                .map(erro -> new Erro400Dto(erro.getField(), erro.getDefaultMessage()))
                .collect(Collectors.toList());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Erro500Dto tratarErro500(Exception ex, HttpServletRequest req) {
        return new Erro500Dto(
                LocalDateTime.now(),
                ex.getClass().toString(),
                ex.getMessage(),
                req.getRequestURI());
    }


}
