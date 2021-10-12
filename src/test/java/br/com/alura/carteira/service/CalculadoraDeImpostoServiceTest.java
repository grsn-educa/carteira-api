package br.com.alura.carteira.service;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;
import br.com.alura.carteira.modelo.Usuario;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculadoraDeImpostoServiceTest {

    @Test
    void transacoDoTipoCompraNaDeveriaTerImposto() {
        Transacao transacao = new Transacao(
                120l,
                "BBSE3",
                LocalDate.now(),
                new BigDecimal(30.00),
                10,
                TipoTransacao.COMPRA,
                new Usuario(1l, "Rafaela", "rafaela@gmail.com", "123456")
        );
        
        CaculadoraDeImpostoService calculadora = new CaculadoraDeImpostoService();
        BigDecimal imposto = calculadora.calcular(transacao);
        assertEquals(BigDecimal.ZERO, imposto);
    }
    
    @Test
    void transacoDoTipoVendaComValorMenorDoQueVinteMilNaDeveriaTerImposto() {
        Transacao transacao = new Transacao(
                120l,
                "BBSE3",
                LocalDate.now(),
                new BigDecimal(30.00),
                10,
                TipoTransacao.VENDA,
                new Usuario(1l, "Rafaela", "rafaela@gmail.com", "123456")
        );
        
        CaculadoraDeImpostoService calculadora = new CaculadoraDeImpostoService();
        BigDecimal imposto = calculadora.calcular(transacao);
        assertEquals(BigDecimal.ZERO, imposto);
    }
    
    @Test
    void deveriaCalcularImpostoDeTransacaoDoTipoVendaComValorMaiorQueVinteMil() {
        Transacao transacao = new Transacao(
                120l,
                "BBSE3",
                LocalDate.now(),
                new BigDecimal(1000.00),
                30,
                TipoTransacao.VENDA,
                new Usuario(1l, "Rafaela", "rafaela@gmail.com", "123456")
        );
        
        CaculadoraDeImpostoService calculadora = new CaculadoraDeImpostoService();
        BigDecimal imposto = calculadora.calcular(transacao);
        assertEquals(new BigDecimal("4500.00"), imposto);
    }

//    public CalculadoraDeImpostoServiceTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
}
