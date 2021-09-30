
package br.com.alura.carteira.repository;

import br.com.alura.carteira.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
     
}


/*@Repository
public class UsuarioDao {
    
    @Autowired
    private EntityManager em;
    
    public void salvar(Usuario usuario){
        em.persist(usuario);
    }
    
    public List<Usuario> listar(){
        return em
                .createQuery("select u from Ususario u", Usuario.class)
                .getResultList();
    }
}
*/