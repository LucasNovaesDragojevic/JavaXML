package br.com.estudo.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Venda {
	
	private String formaPagamento;
	
	@XmlElementWrapper(name="produtos")
	@XmlElement(name="produto")
	private List<Produto> produtos;
	
	public String getFormaPagamento() {
		return formaPagamento;
	}
	
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Venda [formaPagamento=" + formaPagamento + ", produtos=" + produtos + "]";
	}
}
