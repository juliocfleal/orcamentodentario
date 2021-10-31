package com.julioleal.orcamentodentario.enums;

public enum TipoPagamento {
	
	PARTICULAR (1, "Particular"), CONVENIO(1, "Convenio");
	
	private Integer cod;
	private String descricao;
	
	TipoPagamento(Integer cod, String descricao){
		this.cod = cod;
		this.descricao = descricao;
	}
	
	TipoPagamento(){
		
	}

	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}


	public static TipoPagamento toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (TipoPagamento  x : TipoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}

		}

		throw new IllegalArgumentException("Id invalido " + cod);
	}
	
	

}
