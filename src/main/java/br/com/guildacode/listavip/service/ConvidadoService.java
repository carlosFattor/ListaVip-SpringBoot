package br.com.guildacode.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guildacode.enviadorEmail.EmailService;
import br.com.guildacode.listavip.model.Convidado;
import br.com.guildacode.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;
	
	public Iterable<Convidado> findAll(){
		return repository.findAll();
	}
	
	public Convidado save(Convidado convidado){
		Convidado conSalvo = repository.save(convidado);
		sendEmail(conSalvo);
		return conSalvo;		
	}
	
	private void sendEmail(Convidado convidado){
		new EmailService().enviar(convidado.getNome(), convidado.getEmail());
	}
	
}
