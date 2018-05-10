package com.practica2.pc_paolocuenca.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Remuneracion implements Serializable {

   
    @Id
    @GeneratedValue
	private Integer id;
	@NotNull
	@Size(min=2,max=30,message="id no se genero")	
	private String nombre;
	@NotNull
	@Size(min=5,max=30)
	private Double remuneracion;
	@NotNull
	@Size(min=5,max=30)
	private Double montoRemunerarTotal;
	@NotNull
	@Size(min=5,max=30)
	private Double monto5tacategoriacalculado;
	@NotNull
	@Size(min=15,max=30)
	private double montoMensualCategoria;
	@NotNull
	@Size(min=15,max=30)
	
	
	public double getMontoMensualCategoria() {
		return montoMensualCategoria;
	}
	public void setMontoMensualCategoria(double montoMensualCategoria) {
		this.montoMensualCategoria = montoMensualCategoria;
	}
	
	public Double getMonto5tacategoriacalculado() {
		return monto5tacategoriacalculado;
	}
	public void setMonto5tacategoriacalculado(Double monto5tacategoriacalculado) {
		this.monto5tacategoriacalculado = monto5tacategoriacalculado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getRemuneracion() {
		return remuneracion;
	}
	public void setRemuneracion(Double remuneracion) {
		this.remuneracion = remuneracion;
	}

	public Double getMontoRemunerarTotal() {
		return montoRemunerarTotal;
	}
	public void setMontoRemunerarTotal(Double montoRemunerarTotal) {
		this.montoRemunerarTotal = montoRemunerarTotal;
	}


	
	

}
