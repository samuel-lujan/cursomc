package com.example.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_estado;
	private String estado;
	
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades = new ArrayList<>();
	
	public Estado() {
		
	}

	public Estado(Integer id_estado, String estado) {
		super();
		this.id_estado = id_estado;
		this.estado = estado;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_estado == null) ? 0 : id_estado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (id_estado == null) {
			if (other.id_estado != null)
				return false;
		} else if (!id_estado.equals(other.id_estado))
			return false;
		return true;
	}
	
	
	
}
