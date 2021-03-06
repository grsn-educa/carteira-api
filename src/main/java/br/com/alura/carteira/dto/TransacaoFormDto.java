package br.com.alura.carteira.dto;

import br.com.alura.carteira.modelo.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonAlias;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoFormDto {

	@NotNull
	@NotEmpty
	@Size(min = 5, max = 6)
        @Pattern(regexp = "[a-zA-Z]{4}[0-9][0-9]?", message = "{transacao.ticker.invalido}")
	private String ticker;

	@NotNull
	@DecimalMin("0.01")
	private BigDecimal preco;

	@PastOrPresent
	private LocalDate data;

	@NotNull
        @Min(1)
	private int quantidade;

	@NotNull
	private TipoTransacao tipo;
        
        @JsonAlias("usuario_id")
        private Long usuarioId;

}
