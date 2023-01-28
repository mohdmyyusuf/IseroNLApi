package com.inl.test.util;

import java.io.*;
import java.util.*;

import org.json.simple.parser.*;
import org.testng.xml.Parser;

public class JsonReader {
	
	JSONParser pasrer =new JSONParser();
	public void jsonReaderMethod() {
		try {
			Object obj = pasrer.parse(new FileReader("/ApiTestsIseroNL/src/main/java/com/inl/test/data/users.json"));
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
