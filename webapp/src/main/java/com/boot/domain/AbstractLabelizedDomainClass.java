package com.boot.domain;

abstract public class AbstractLabelizedDomainClass extends AbstractDomainClass{

	private String label;

	public AbstractLabelizedDomainClass(String label) {
		super();

		setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	private void setLabel(String label) {
		this.label = label;
	}	
}