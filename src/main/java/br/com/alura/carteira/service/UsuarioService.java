package br.com.alura.carteira.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.carteira.dto.UsuarioDto;
import br.com.alura.carteira.dto.UsuarioFormDto;
import br.com.alura.carteira.modelo.Usuario;
import br.com.alura.carteira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioDto> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(t -> modelMapper.map(t, UsuarioDto.class)).collect(Collectors.toList());
    }

    public void cadastrar(UsuarioFormDto dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);

        String senha = new Random().nextInt(999999) + "";
        usuario.setSenha(senha);

        usuarioRepository.save(usuario);
        
        }

}
/*
	private List<Usuario> usuarios = new ArrayList<>();
	private ModelMapper modelMapper = new ModelMapper();

	public List<UsuarioDto> listar() {
		return usuarios.stream().map(t -> modelMapper.map(t, UsuarioDto.class)).collect(Collectors.toList());
	}

	public void cadastrar(UsuarioFormDto dto) {
		Usuario usuario = modelMapper.map(dto, Usuario.class);

		String senha = new Random().nextInt(999999) + "";
		usuario.setSenha(senha);

		usuarios.add(usuario);
	}
 */
