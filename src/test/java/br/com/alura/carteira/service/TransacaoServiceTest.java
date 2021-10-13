package br.com.alura.carteira.service;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;
import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.repository.TransacaoRepository;
import br.com.alura.carteira.repository.UsuarioRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransacaoServiceTest {

    @Mock
    private TransacaoRepository transacaoRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private TransacaoService service;

    @Test
    void deveriaCadastrarUmaTransacao() {
        TransacaoFormDto formDto = new TransacaoFormDto(
                "ITSA4",
                new BigDecimal("10.45"),
                LocalDate.now(),
                120,
                TipoTransacao.COMPRA,
                1l
        );

        TransacaoDto dto = service.cadastrar(formDto);

        assertEquals(formDto.getTicker(), dto.getTicker());
        assertEquals(formDto.getPreco(), dto.getPreco());
        assertEquals(formDto.getQuantidade(), dto.getQuantidade());
        assertEquals(formDto.getTipo(), dto.getTipo());
    }

}
