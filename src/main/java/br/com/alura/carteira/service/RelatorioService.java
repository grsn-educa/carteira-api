package br.com.alura.carteira.service;

import br.com.alura.carteira.dto.ItemCarteiraDto;
import br.com.alura.carteira.repository.TransacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {
    
    
    @Autowired
    private TransacaoRepository repository;
    
    public List<ItemCarteiraDto> relatorioCarteiraDeInvestimentos(){
        return repository.relatorioCarteiraDeInvestimentos();
    } 
    
}
