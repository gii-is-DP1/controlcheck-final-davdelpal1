package org.springframework.samples.petclinic.care;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class CareFormatter implements Formatter<Care>{
	private CareService careService;
	@Autowired
	public CareFormatter(CareService careService) {
		this.careService = careService;
	}
	
    @Override
    public String print(Care object, Locale locale) {
        // TODO Auto-generated method stub
        return object.getName();
    }

    @Override
    public Care parse(String text, Locale locale) throws ParseException {
        // TODO Auto-generated method stub
    	Care c = careService.getCare(text);
    	if(c != null) {
    		return c;
    	}
    	throw new ParseException("type not found: " + text, 0);
    }
    
}
