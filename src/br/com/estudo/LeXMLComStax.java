package br.com.estudo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import br.com.estudo.model.Produto;

public class LeXMLComStax {
	
	public static void main(String[] args) throws Exception {
		InputStream ips = new FileInputStream("src/vendas.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader events = factory.createXMLEventReader(ips);
		
		List<Produto> produtos = new ArrayList<>();
		
		while (events.hasNext()) {
			XMLEvent event = events.nextEvent();
			
			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("produto")) {
				Produto produto = criaUmProdutoComEventos(events);
				produtos.add(produto);
			}
				
		}
		System.out.println(produtos);
	}

	private static Produto criaUmProdutoComEventos(XMLEventReader events) throws Exception {
		Produto produto = new Produto();

		while (events.hasNext()) {
			XMLEvent event = events.nextEvent();
			
			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("nome")) {
				event = events.nextEvent();
				String nome = event.asCharacters().getData();
				produto.setNome(nome);
				
			} else if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("preco")) {
				event = events.nextEvent();
				String conteudo = event.asCharacters().getData();
				Double preco = Double.parseDouble(conteudo);
				produto.setPreco(preco);
				
			} else if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("produto")) {
				break;
			}
		}
		
		return produto;
	}
}
