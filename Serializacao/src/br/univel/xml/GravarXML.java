package br.univel.xml;

import java.io.File;
import java.rmi.MarshalledObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class GravarXML {
	public static void main(String[] args) {
		Produto prod = new Produto();
		prod.setId(1);
		prod.setNome("Robertao");
		
		try {
			File file = new File("file.xml");
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext
					.newInstance(Produto.class);
			
			Marshaller jaxbMarshaller = jaxbContext
					.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(prod, file);
			jaxbMarshaller.marshal(prod, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
