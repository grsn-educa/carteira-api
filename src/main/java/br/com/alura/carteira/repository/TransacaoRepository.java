
package br.com.alura.carteira.repository;

import br.com.alura.carteira.modelo.Transacao;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
    
}

/*
@Repository
public class TransacaoDao {
    
    @Autowired
    private EntityManager em;
    
    public void salvar(Transacao transacao){
        em.persist(transacao);
    }
    
    public List<Transacao> listar(){
        return em
                .createQuery("select t from Transacao t", Transacao.class)
                .getResultList();
    }
}
*/