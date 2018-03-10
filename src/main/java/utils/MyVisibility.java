package utils;

import javax.persistence.Embeddable;

@Embeddable
public final class MyVisibility {
	
	  static  String ENABLED = "enabled";
	   String DESABLED = "desabled";
	  final String ACTIVE = "ACTIVE";
	
	public String getENABLED() {
		return ENABLED;
	}
	public String getDESABLED() {
		return DESABLED;
	}
	public String getACTIVE() {
		return ACTIVE;
	}
	
	
	
}
