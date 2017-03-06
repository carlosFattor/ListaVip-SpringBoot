package br.com.guildacode.listavip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.guildacode.listavip.model.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long>{

	public List<Convidado> findByNome(String nome);
	
}
