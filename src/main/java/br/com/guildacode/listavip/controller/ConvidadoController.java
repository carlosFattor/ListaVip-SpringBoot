package br.com.guildacode.listavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.guildacode.listavip.model.Convidado;
import br.com.guildacode.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService convidadoService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/convidados")
	public ModelAndView convidados(){
		ModelAndView modelAndView = new ModelAndView("listaconvidado");
		
		Iterable<Convidado> convidados = convidadoService.findAll();
		modelAndView.addObject("convidados", convidados);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/convidados/salvar", method=RequestMethod.POST)
	public String salvar(Convidado convidado, RedirectAttributes attributes){
		
		convidadoService.save(convidado);
		
		attributes.addFlashAttribute("sucesso", "Convidado cadastrado com sucesso");
		
		return "redirect:../convidados";
	}
}
