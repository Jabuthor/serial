package br.univel.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LerXML {

	public static void main(String[] args) {
		try {
			File file = new File("file.xml");
			
			JAXBContext jc = JAXBContext
					.newInstance(Produto.class);
			
			Unmarshaller ju = jc.createUnmarshaller();
			Produto produto = (Produto) ju.unmarshal(file);
			
			System.out.println(produto.getNome());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
}
