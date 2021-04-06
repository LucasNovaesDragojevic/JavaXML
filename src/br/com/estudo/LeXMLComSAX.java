package br.com.estudo;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.estudo.handler.ProdutosHandler;

public class LeXMLComSAX {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		ProdutosHandler logica = new ProdutosHandler();
		reader.setContentHandler(logica);
		InputStream ips = new FileInputStream("src/vendas.xml");
		InputSource is = new InputSource(ips);
		reader.parse(is);
		System.out.println(logica.getProdutos());
	}

}
