package org.huit.ces.model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable{

	String id;
	String type;
	
	public BaseModel() {
		type = getClass().getSimpleName();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
