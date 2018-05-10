package com.practica2.pc_paolocuenca.repository;

import java.util.List;

import com.practica2.pc_paolocuenca.model.Remuneracion;


public interface RemuneracionRepository {

	void save(Remuneracion remuneracion);
	List<Remuneracion> finAll();
	Remuneracion findById(Integer id);
	void delete (Remuneracion remuneracion); 
	
}
