package br.com.alura.carteira.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;
import br.com.alura.carteira.modelo.Transacao;
import br.com.alura.carteira.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public Page<TransacaoDto> listar(Pageable paginacao) {
        Page<Transacao> transacoes = transacaoRepository.findAll(paginacao);
        return transacoes.map(t -> modelMapper.map(t, TransacaoDto.class));
    }
    
    @Transactional  
    public TransacaoDto cadastrar(TransacaoFormDto dto) {
        Transacao transacao = modelMapper.map(dto, Transacao.class);
        transacao.setId(null);
        transacaoRepository.save(transacao);
        return modelMapper.map(transacao, TransacaoDto.class);
    }
}
        /*
	private List<Transacao> transacoes = new ArrayList<>();
	private ModelMapper modelMapper = new ModelMapper();

	public List<TransacaoDto> listar() {
		return transacoes.stream().map(t -> modelMapper.map(t, TransacaoDto.class)).collect(Collectors.toList());
	}

	public void cadastrar(TransacaoFormDto dto) {
		Transacao transacao = modelMapper.map(dto, Transacao.class);
		transacoes.add(transacao);
	}
        */
