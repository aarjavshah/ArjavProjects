package com.java;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class HelloWorldFreeMarker {

	public static StringWriter getWebPage(){
		// TODO Auto-generated method stub
		StringWriter writer = null;
		Configuration config = new Configuration();
		config.setClassForTemplateLoading(HelloWorldFreeMarker.class, "/");
		try {
			Template sample = config.getTemplate("form.ftl");
			writer = new StringWriter();
			HashMap<String, Object> helloMap = new HashMap<String, Object>();
			helloMap.put("colors", Arrays.asList("yellow","blue","white","red","cyan"));
			sample.process(helloMap, writer);
		} catch (TemplateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//System.out.println(writer);}
			return writer;}
	}

}
