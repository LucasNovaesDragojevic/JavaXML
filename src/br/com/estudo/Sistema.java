package br.com.estudo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.estudo.model.Produto;

public class Sistema {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		fabrica.setValidating(true);
		fabrica.setNamespaceAware(true);
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document document = builder.parse("src/vendas.xml");
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println(moeda);

		String exp = "/venda/produtos/produto[contains(nome, 'java')]";
		
		XPath path = XPathFactory.newInstance().newXPath();
		XPathExpression expression = path.compile(exp);
		
		NodeList produtos = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
		
		for (int i = 0; i < produtos.getLength(); i++) {
			Element item = (Element) produtos.item(i);
			String nome = item.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(item.getElementsByTagName("preco").item(0).getTextContent());			
			Produto produto = new Produto(nome, preco);
			System.out.println(produto);
		}		
	}

}
