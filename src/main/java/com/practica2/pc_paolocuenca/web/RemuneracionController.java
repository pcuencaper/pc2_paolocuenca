package com.practica2.pc_paolocuenca.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.practica2.pc_paolocuenca.model.Remuneracion;
import com.practica2.pc_paolocuenca.repository.RemuneracionRepository;

@Controller
public class RemuneracionController {

	@Autowired
	private RemuneracionRepository remuneracionRepository ; 
	
	public  Remuneracion calcularTotal(Remuneracion remuneracion) {
		
		double uit=4050;
		double deduccionUit=0;
		double rentabruta=remuneracion.getRemuneracion();
		double categoria5=0;
		double montoxCatego=0;
		double montomensual=montoxCatego/12;
        remuneracion.setMonto5tacategoriacalculado(categoria5);
        remuneracion.setMontoRemunerarTotal(montoxCatego);
        remuneracion.setMontoMensualCategoria(montomensual);
   
        //categorizaelmontoaproximado
      		deduccionUit=uit*7;
      		
      		//calcula si el sueldo es valido	
      		if(rentabruta==0) {
      			rentabruta=rentabruta*0;
      		}else {
      			rentabruta=rentabruta*12;
      		}

      		//calcula el monto de remuneracion de 5ta categoria
      		 categoria5=rentabruta-deduccionUit;
      		 
       if(categoria5<20250) {
    	   montoxCatego=categoria5*0;
       }else {
    	   if(categoria5==20250) {
    		   montoxCatego=categoria5*0.08;
    	   }else {
    		   if(categoria5>20250&&categoria5<=81000) {
    			   montoxCatego=categoria5*0.14;
    		   }else {
    			   if(categoria5>81000&&categoria5<=141750) {
    				   montoxCatego=categoria5*0.17;
    			   }else {
    				   if(categoria5>141750&&categoria5<=182250) {
    					   montoxCatego=categoria5*0.2;
    				   }else {
    					       montoxCatego=categoria5*0.3;
    				   }
    			   }
    		   }
    	   }
       }
		
		
		
		 
		return remuneracion;
	}
	
	  @GetMapping("/remuneracion/calcularMonto")
	  private String initform(Model model) {
		  model.addAttribute(new Remuneracion());
		  return "form";
	  }
	  //jj
	  
	  @PostMapping("/remuneracion/calcularMonto")
	  private String submitform(@Valid Remuneracion remuneracion , BindingResult bindingResult) {
		  if(bindingResult.hasFieldErrors()) {
			  return "form";
		  }
		  Remuneracion _remuneracion = calcularTotal(remuneracion);
		  remuneracionRepository.save(_remuneracion);
		  
		  return "redirect:/remuneracion/listar";
	  }
	  
	  @GetMapping("/remuneracion/listar")
	  private String listar(Map<String, Object>model) {
		  List<Remuneracion> remuneraciones=remuneracionRepository.finAll();
		  model.put("remuneracion",remuneraciones );
		  return "listRemuneracion";
	  }
	  
	
	

}

