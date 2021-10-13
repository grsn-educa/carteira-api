package br.com.alura.carteira.service;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;
import br.com.alura.carteira.modelo.Transacao;
import br.com.alura.carteira.repository.TransacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    
//    @Autowired
//    private UsuarioRepository usuarioRepository;
    
    private ModelMapper modelMapper = new ModelMapper();

    public Page<TransacaoDto> listar(Pageable paginacao) {
        Page<Transacao> transacoes = transacaoRepository.findAll(paginacao);
        return transacoes.map(t -> modelMapper.map(t, TransacaoDto.class));
    }
    
    @Transactional  
    public TransacaoDto cadastrar(TransacaoFormDto dto) {
//        throw new NullPointerException("teste");
        Transacao transacao = modelMapper.map(dto, Transacao.class);
        transacao.setId(null);
        transacaoRepository.save(transacao);
        return modelMapper.map(transacao, TransacaoDto.class);
    }
}