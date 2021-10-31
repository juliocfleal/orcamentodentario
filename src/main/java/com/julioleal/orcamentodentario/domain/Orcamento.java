package com.julioleal.orcamentodentario.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.julioleal.orcamentodentario.enums.TipoPagamento;

@Entity
public class Orcamento implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double valor;
	
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="paciente_id")
	@MapsId
	private Paciente paciente;
	


	@ManyToOne
	@JoinColumn(name="dentista_id")
	private Dentista dentista;
	
	
	private TipoPagamento tipoPagamento;
	
	public Orcamento() {
		
	}
	
	
	public Orcamento(Integer id, Double valor, Date data, Paciente paciente, Dentista dentista,
			TipoPagamento tipoPagamento) {
		super();
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.paciente = paciente;
		this.dentista = dentista;
		this.tipoPagamento = tipoPagamento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Dentista getDentista() {
		return dentista;
	}
	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		return Objects.equals(id, other.id);
	}
	

	
	
}
