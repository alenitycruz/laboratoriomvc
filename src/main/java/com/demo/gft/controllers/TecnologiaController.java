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

import com.demo.gft.entity.Tecnologia;
import com.demo.gft.service.TecnologiaService;

@Controller
@RequestMapping("tecnologia")
public class TecnologiaController {

	@Autowired
	private TecnologiaService tecnologiaService;
	
	//////////////////////////CREATE////////////////////////////////////////////
	
	@RequestMapping(path = "novo")
	public ModelAndView formPostTecnologia() {
		ModelAndView mv = new ModelAndView("tecnologia/form.html");
		mv.addObject("tecnologia", new Tecnologia());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , path = "novo")
	public ModelAndView postTecnologia(@Valid Tecnologia tecnologia, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("tecnologia/form.html");
		
		boolean novo = true;
		
		if(tecnologia.getId_tecnologia() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("tecnologia", tecnologia);
			return mv;
		}
		
		Tecnologia tecnologiaSave = tecnologiaService.createTecnologia(tecnologia);
		
		if(novo) {
			mv.addObject("tecnologia", new Tecnologia());
		}else {
			mv.addObject("tecnologia", tecnologiaSave);
			
		}
		
		return mv;
	}
	
	///////////////////////////////////READ/////////////////////////////////////////
	
	@RequestMapping
	public ModelAndView getAllTecnologia() {
		ModelAndView mv = new ModelAndView("tecnologia/listar.html");
		mv.addObject("listaTecnologia", this.tecnologiaService.readyAll());
		
		return mv;
	}	
	
	/////////////////////////////////UPDATE//////////////////////////////////
	
	@RequestMapping("/editar")
	public ModelAndView updadeTecnologiaController(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("tecnologia/form.html");
		Tecnologia tecnologia;
		
		try {
			tecnologia = tecnologiaService.readyId(id);
		}catch(Exception e) {
			tecnologia = new Tecnologia();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("tecnologia", tecnologia);
		
		return mv;
	}

	
	//////////////////////////////DELETE//////////////////////////////////////
	
	@RequestMapping("/excluir")
	public ModelAndView deleteTecnologiaController(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/tecnologia");

		try {
			this.tecnologiaService.delete(id);
			 redirectAttributes.addFlashAttribute("mensagem", "Tecnologia excluída com sucesso.");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Tecnologia!"+e.getMessage());
		}
				
		return mv;
	}
}
