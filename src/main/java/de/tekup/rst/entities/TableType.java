package de.tekup.rst.entities;

import lombok.Getter;

public enum TableType {
	
	OUTSIDE("Outside"), INSIDE_SMOKER("Inside Smoker"), INSIDE_NO_SMOKER("Inside No Smoker");
	
	@Getter private String displayValue;
	
	private TableType(String dispVal) {
		displayValue=dispVal;
	}

}
