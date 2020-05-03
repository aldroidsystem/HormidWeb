package test;

import java.util.Date;

import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aldroid.hormid.lapak.bean.HargaBean;


public class Test {
	static ApplicationContext context;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("halo");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(false); // This avoid to search schema online
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", "TransactionMessage_v1.0.xsd");

        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HargaBean bean = new HargaBean();
        bean.setCreatedBy("admin");
        bean.setCreatedDate(new Date());
        bean.setHargaJual(1250);
        bean.setHargaBeli(1200);
        Test2 tt = (Test2) context.getBean("test2");
        tt.testInsert(bean);
		System.out.println("sucess");
	}

}
