package com.rafael.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rafael.domain.Mercadoria;
import com.rafael.domain.StatusMercadoria;
import com.rafael.repository.Mercadorias;

@Controller
@RequestMapping("mercadorias")
public class MercadoriasController {
	private static final String MercadoriasView = "CadastroMercadoria";
	@Autowired
	private Mercadorias mr;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Model m) {
		ModelAndView mv = new ModelAndView("CadastroMercadoria");
		mv.addObject(new Mercadoria());
		return mv;
	}
	
	@RequestMapping()
	public ModelAndView pesquisar() {
		List<Mercadoria> TodasMercadorias = mr.findAll();
		ModelAndView mv = new ModelAndView("PesquisaMercadoria");
		mv.addObject("mercadoria", TodasMercadorias);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Mercadoria mercadoria, Errors erro, RedirectAttributes atributes) {
		if(erro.hasErrors()){
			return "CadastroMercadoria";
		}
		try {
			//this.serv.salvar(titulo);
			mr.save(mercadoria);
			atributes.addFlashAttribute("mensagem","Mercadoria salva com sucesso!");
			return "redirect:/mercadorias/novo";
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			return "CadastroMercadoria";
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public ModelAndView edicao(@PathVariable("id") Mercadoria mercadoria) {
		ModelAndView mv = new ModelAndView(MercadoriasView);
		mv.addObject(mercadoria);
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String remover(@PathVariable Long codigo, RedirectAttributes attributes) {
		this.mr.delete(codigo);
		//this.serv.excluir(codigo);
		attributes.addAttribute("mensagem","O titulo foi excluído com sucesso");
		return "redirect:/mercadorias";
	}
	
	@ModelAttribute("todosStatusMercadoria")
	public List<StatusMercadoria> todosStatusTitulo() {
		return Arrays.asList(StatusMercadoria.values());
	}
}
