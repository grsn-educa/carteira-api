package br.com.alura.carteira.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"data", "quantidade", "tipo"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
/* indica que è uma classe que mapeia uma tabela no banco de dados */
@Table(name = "transacoes")
public class Transacao {

    @Id //indica chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticker;
    private LocalDate data;
    private BigDecimal preco;
//  private int quantidade;
    private Integer quantidade;
    
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;
    
    @ManyToOne
//    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}

/*
    @Column(name = "nomeDaColuna") - em cima do atributo
*/
