package com.mvtechbytes.fmt;

import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.InputSource;

import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.ext.dom.NodeModel;
import freemarker.template.Configuration;
import freemarker.template.TemplateHashModel;

public class FmtExecution {
	
	public static void main(String[] args) throws Exception {
		FmtManager fmtManager = new FmtManager();
		
		// Transformation from xml to json
		xmlToJson(fmtManager);
		
		// Transformation from json to xml
		jsonToXml(fmtManager);
	}

	private static void jsonToXml(FmtManager templateManager) throws Exception {
		 String input = new String(Files.readAllBytes(Paths.get("src/main/resources/test.json")));

	        Map<String, Object> data = new HashMap<>();
	        data.put("input", input);

	        TemplateHashModel staticModels = new BeansWrapperBuilder(Configuration.VERSION_2_3_23).build().getStaticModels();
	        data.put("JsonUtil", staticModels.get(FmtJsonUtil.class.getName()));

	        String output = templateManager.processTemplate("json2xml", data);

	        System.out.println(output);
	}
	
	public static void xmlToJson(FmtManager templateManager) throws Exception {

        String xmlString = new String(Files.readAllBytes(Paths.get("src/main/resources/test.xml")));
        NodeModel xmlNodeModel = NodeModel.parse(new InputSource(new StringReader(xmlString)));

        Map<String, Object> data = new HashMap<>();
        data.put("xml", xmlNodeModel);

        String json = templateManager.processTemplate("xml2json", data);

        System.out.println(json);
    }
	
	
}
