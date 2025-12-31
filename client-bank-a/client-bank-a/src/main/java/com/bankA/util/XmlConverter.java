package com.bankA.util;

import java.io.StringWriter;

import com.bankA.dao.TransactionXml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class XmlConverter {

	 public static String convertToXml(TransactionXml transaction) {
	        try {
	            JAXBContext context = JAXBContext.newInstance(TransactionXml.class);
	            Marshaller marshaller = context.createMarshaller();
	            StringWriter writer = new StringWriter();
	            marshaller.marshal(transaction, writer);
	            return writer.toString();
	        } catch (Exception e) {
	            throw new RuntimeException("XML Conversion Failed", e);
	        }
	    }
}
