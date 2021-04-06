package br.com.estudo;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.estudo.model.Produto;
import br.com.estudo.model.Venda;

public class MapeiaXML {

	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		
		//objetoParaXML(jaxbContext);
		
		xmlParaObjeto(jaxbContext);
	}

	private static void objetoParaXML(JAXBContext jaxbContext) throws Exception {
		Marshaller marshaller = jaxbContext.createMarshaller();
		Venda venda = new Venda();
		venda.setFormaPagamento("Crediário");
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Iphone", 3000.00));
		produtos.add(new Produto("Galaxy", 2500.00));
		produtos.add(new Produto("Redmi Note", 100.00));
		
		venda.setProdutos(produtos);
		
		StringWriter writer = new StringWriter();
		
		marshaller.marshal(venda , writer);
		
		System.out.println(writer);
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws Exception {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		System.out.println(venda);
	}
}
