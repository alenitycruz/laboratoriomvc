package com.demo.gft.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.gft.entity.Starter;
import com.demo.gft.service.StarterService;
import com.demo.gft.service.TecnologiaService;

@Controller
@RequestMapping("starter")
public class StarterController {
	
	@Autowired
	private StarterService starterService;
	
	@Autowired
	private TecnologiaService tecnologiaService;
	
	//////////////////////////////CREATE///////////////////////////////////
	
	@RequestMapping(method = RequestMethod.POST , path = "editar")
	public ModelAndView postStarter(@Valid Starter starter, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("starter/form.html");
		
		boolean novo = true;
		
		if(starter.getId_starter() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("starter", starter);
			return mv;
		}
		
		Starter starterSalvar = this.starterService.create(starter);
	
		if(novo) {
			mv.addObject("starter", new Starter());
		}else {
			mv.addObject("starter", starterSalvar);
		}
		
		mv.addObject("mensagem", "Starter salvo com sucesso");
		mv.addObject("listaTecnologia", this.tecnologiaService.readyAll());
		
		
		return mv;
		
	}
	
	
	
	//////////////////////////////READY///////////////////////////////////
	
	@RequestMapping
	public ModelAndView getAllStarter() {
		ModelAndView mv = new ModelAndView("starter/listar.html");
		mv.addObject("lista", this.starterService.readyAll());
		
		return mv;
	}
	
	//////////////////////////////UPDATE///////////////////////////////////	
	
	@RequestMapping(path = "editar")
	public ModelAndView updadeStarterController(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("starter/form.html");
		
		Starter starter;
		
		if(id==null) {
			starter = new Starter();
		}else {
			try {
				starter = this.starterService.readId(id);
			}catch(Exception e) {
				starter = new Starter();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		mv.addObject("starter", starter);
		mv.addObject("listaTecnologia", this.tecnologiaService.readyAll());

		
		return mv;
		
	}

	
	//////////////////////////////DELETE///////////////////////////////////

	@RequestMapping("/excluir")
	public ModelAndView deleteController(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/starter");

		try {
			starterService.delete(id);
			 redirectAttributes.addFlashAttribute("mensagem", "Starter excluída com sucesso.");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Starter!"+e.getMessage());
		}
				
		return mv;
	}
}
